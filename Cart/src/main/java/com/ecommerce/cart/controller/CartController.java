package com.ecommerce.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart.dto.CartInDto;
import com.ecommerce.cart.dto.CartOutDto;
import com.ecommerce.cart.dto.ResponseOutDto;
import com.ecommerce.cart.exception.InsufficientQuantityException;
import com.ecommerce.cart.exception.RecordNotFoundException;
import com.ecommerce.cart.service.CartService;

@RestController
@RequestMapping("/ecommerce/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("")
	public ResponseEntity<ResponseOutDto> addToCart(@RequestBody CartInDto cartInDto) throws RecordNotFoundException
	{
		
		LOGGER.info("Request Received to add the product of id :{} into the cart",cartInDto.getProductId());
		ResponseOutDto responseOutDto = cartService.addtoCart(cartInDto);
		LOGGER.info("Request Completed to add the product of id :{} into the cart",cartInDto.getProductId());
		return ResponseEntity.status(HttpStatus.OK).body(responseOutDto);
	}
	
	@PutMapping("/{cartId}")
	public ResponseEntity<ResponseOutDto> updateCart(@PathVariable final String cartId,@RequestBody final CartInDto cartInDto ) throws InsufficientQuantityException, RecordNotFoundException
	{
		LOGGER.info("Request Received to update the quantity of product for cart id :{}",cartId);
		 ResponseOutDto responseOutDto = cartService.updateCart(cartInDto,cartId);
		LOGGER.info("Request Completed to update the quantity of product for cart id :{}",cartId);
		return ResponseEntity.status(HttpStatus.OK).body(responseOutDto);
	}
	
	@GetMapping(path = "")
	public ResponseEntity<CartOutDto> getCart(
			final @RequestParam Long userId) throws Exception {
		LOGGER.info("Request Received to get cart for userId {}"+ userId);
		CartOutDto cartOutDto = cartService.getCart(userId);
		LOGGER.info("Request completed to Get cart for userId {}"+ userId);
		return ResponseEntity.status(HttpStatus.OK).body(cartOutDto);
	}
	
	@DeleteMapping("/user/{userId}/product/{productId}")
	public ResponseEntity<ResponseOutDto> deleteProductFromCart(@PathVariable final String productId, @PathVariable final Long userId) throws RecordNotFoundException
	{
		LOGGER.info("Request Received to delete product from cart for Id {}"+ productId);
		ResponseOutDto responseOutDto= cartService.deleteProductFromCart(userId,productId);
		LOGGER.info("Request completed to delete product from cart for Id {}"+ productId);
		return ResponseEntity.status(HttpStatus.OK).body(responseOutDto);
	}
}
