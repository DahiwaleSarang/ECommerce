package com.ecommerce.cart.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.cart.constant.Constants;
import com.ecommerce.cart.dto.CartInDto;
import com.ecommerce.cart.dto.CartOutDto;
import com.ecommerce.cart.dto.CartProductOutDto;
import com.ecommerce.cart.dto.CartProducts;
import com.ecommerce.cart.dto.ProductOutDto;
import com.ecommerce.cart.dto.ResponseOutDto;
import com.ecommerce.cart.dto.UserOutDto;
import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.entity.Product;
import com.ecommerce.cart.exception.InsufficientQuantityException;
import com.ecommerce.cart.exception.RecordNotFoundException;
import com.ecommerce.cart.feign.ProductClient;
import com.ecommerce.cart.feign.UserClient;
import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.cart.repository.ProductRepository;

@Service
public class CartService {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductClient productClient;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserClient userClient;

	public ResponseOutDto addtoCart(CartInDto cartInDto) throws RecordNotFoundException {

		CartProducts cartProduct = new CartProducts();
		String ProductId = cartInDto.getProductId();

		ResponseEntity<ProductOutDto> productById = productClient.getProductById(ProductId);
		if (!productById.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("This product is not found, please check other product!!");

		ResponseEntity<UserOutDto> userDetails = userClient.getUserDetails(cartInDto.getUserId());

		if (!userDetails.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("User is not Found!!");

		cartProduct.setProductId(cartInDto.getProductId());
		cartProduct.setQuantity(cartInDto.getQuantity());
		cartProduct.setCreated_at(Instant.now());
		cartProduct.setUpdated_at(Instant.now());

		List<CartProducts> products;
		

		Cart cart ;
		Optional<Cart> isCartPresent = cartRepository.findByUserId(cartInDto.getUserId());
		if(isCartPresent.isPresent())
		{
			cart = isCartPresent.get();
			products=cart.getCartProducts();
		}
		else
		{
			cart=new Cart();
			 products= new ArrayList<>();
		}
		products.add(cartProduct);
		cart.setCartProducts(products);
		cart.setUserId(cartInDto.getUserId());
		cart.setCartProducts(products);

		cartRepository.save(cart);
		ResponseOutDto responseOutDto = new ResponseOutDto();
		responseOutDto.setMessage(Constants.CART_ADDED);
		return responseOutDto;
	}

	public ResponseOutDto updateCart(CartInDto cartInDto, String cartId)
			throws InsufficientQuantityException, RecordNotFoundException {

		ResponseEntity<UserOutDto> userDetails = userClient.getUserDetails(cartInDto.getUserId());
		if (!userDetails.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("User is not Found!!");

		ResponseEntity<ProductOutDto> productById = productClient.getProductById(cartInDto.getProductId());
		if (!productById.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("This product is not found, please check other product!!");

		ProductOutDto product = productById.getBody();
		if (cartInDto.getQuantity() > product.getQuantity())
			throw new InsufficientQuantityException(String.format(
					"we have %S availble piece for this produt, please check other products!!", product.getQuantity()));

		Optional<Cart> findById = cartRepository.findById(cartId);
		if (!findById.isPresent())
			throw new RecordNotFoundException("Cart Details Not Found!!");

		Cart existingCart = findById.get();
		List<CartProducts> existingProducts = existingCart.getCartProducts();
		Optional<CartProducts> productInCart = existingProducts.stream()
				.filter(prod -> prod.getProductId().equals(cartInDto.getProductId())).findFirst();

		CartProducts cartProduct = new CartProducts();

		if (!productInCart.isEmpty()) {
			cartProduct.setCreated_at(productInCart.get().getCreated_at());
			existingProducts.remove(productInCart.get());
		}

		cartProduct.setQuantity(cartInDto.getQuantity());
		cartProduct.setProductId(cartInDto.getProductId());
		cartProduct.setUpdated_at(Instant.now());

		existingProducts.add(cartProduct);
		existingCart.setCartProducts(existingProducts);
		cartRepository.save(existingCart);

		ResponseOutDto responseOutDto = new ResponseOutDto();
		responseOutDto.setMessage(Constants.CART_UPDATED);

		return responseOutDto;
	}

	public CartOutDto getCart(Long userId) throws RecordNotFoundException {

		ResponseEntity<UserOutDto> userDetails = userClient.getUserDetails(userId);

		if (!userDetails.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("User is not Found!!");
		Optional<Cart> optCart = cartRepository.findByUserId(userId);
		if (optCart.isEmpty()) {
			throw new RecordNotFoundException(Constants.NO_CARTS_AVAILABLE);
		}

		List<CartProductOutDto> cartProductoutDtos = new ArrayList<CartProductOutDto>();

		List<CartProducts> cartProducts = optCart.get().getCartProducts();
		for (CartProducts prod : cartProducts) {
			Optional<Product> optProduct = productRepository.findById(prod.getProductId());

			if (optProduct.isEmpty()) {
				throw new RecordNotFoundException(Constants.PRODUCTS_NOT_FOUND);
			}

			CartProductOutDto cartProductoutDto = mapper.map(optProduct.get(), CartProductOutDto.class);
			cartProductoutDto.setQuantity(prod.getQuantity());
			cartProductoutDtos.add(cartProductoutDto);
		}

		CartOutDto cartOutDto = new CartOutDto();
		cartOutDto.setCartProductOutDtos(cartProductoutDtos);
		cartOutDto.setCart_id(optCart.get().getCart_id());
		cartOutDto.setUserId(optCart.get().getUserId());

		return cartOutDto;
	}

	public ResponseOutDto deleteProductFromCart(Long userId, String productId) throws RecordNotFoundException {

		ResponseEntity<UserOutDto> userDetails = userClient.getUserDetails(userId);
		if (!userDetails.getStatusCode().equals(HttpStatus.OK))
			throw new RecordNotFoundException("User is not Found!!");
		Optional<Cart> findByUserId = cartRepository.findByUserId(userId);
		if (!findByUserId.isPresent())
			throw new RecordNotFoundException(Constants.CART_NOT_FOUND);

		Cart existingCart = findByUserId.get();
		List<CartProducts> existingProducts = existingCart.getCartProducts();

		Optional<CartProducts> findFirst = existingProducts.stream()
				.filter(prod -> prod.getProductId().equals(productId)).findFirst();
		CartProducts cartProduct = findFirst.get();

		existingProducts.remove(cartProduct);

		existingCart.setCartProducts(existingProducts);
		cartRepository.save(existingCart);

		ResponseOutDto responseOutDto = new ResponseOutDto();
		responseOutDto.setMessage(Constants.CART_DELETED);
		return responseOutDto;
	}

}
