package com.ecommerce.product.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.dto.ProductInDto;
import com.ecommerce.product.dto.ProductOutDto;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.exception.InvalidDetailsException;
import com.ecommerce.product.exception.ProductNotFoundException;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	ModelMapper mapper = new ModelMapper();

	public List<ProductOutDto> getAllProducts() throws ProductNotFoundException {
		List<Product> findAll = productRepository.findAll();

		if (Objects.isNull(findAll) || findAll.size() == 0) {
			throw new ProductNotFoundException("Product not Found!!");
		}

		return findAll.stream().map(prod -> mapper.map(prod, ProductOutDto.class)).collect(Collectors.toList());
	}

	public ProductOutDto createProduct(ProductInDto productInDto,Long userId) throws InvalidDetailsException {

		if (Objects.isNull(productInDto.getName()) || productInDto.getQuantity() == 0 || productInDto.getPrice() == 0) {
			throw new InvalidDetailsException("Invalid Data, check the input Data!!");
		}

		Product product = mapper.map(productInDto, Product.class);
		product.setUserId(userId);
		product.setCreatedAt(Instant.now());
		product.setUpdatedAt(Instant.now());
		product = productRepository.save(product);
		return mapper.map(product, ProductOutDto.class);
	}

	public ProductOutDto updateProduct(ProductInDto productInDto, String productId) throws ProductNotFoundException {

		Optional<Product> findById = productRepository.findById(productId);

		if (findById.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!!");
		}

		Product existingProduct = findById.get();
		Product product = mapper.map(productInDto, Product.class);
		product.setId(existingProduct.getId());
		product.setCreatedAt(existingProduct.getCreatedAt());
		product.setUpdatedAt(Instant.now());

		Product updatedProduct = productRepository.save(product);
		return mapper.map(updatedProduct, ProductOutDto.class);
	}

	public void deleteProduct(String productId) throws ProductNotFoundException {
		Optional<Product> findById = productRepository.findById(productId);

		if (findById.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!!");
		}
		productRepository.deleteById(productId);
	}

	public ProductOutDto getProductById(String productId) throws ProductNotFoundException {
		
		Optional<Product> findById = productRepository.findById(productId);

		if (findById.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!!");
		}
		Product product = findById.get();
		return mapper.map(product, ProductOutDto.class);
	}

}
