package com.ecommerce.product.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.dto.ProductInDto;
import com.ecommerce.product.dto.ProductOutDto;
import com.ecommerce.product.exception.InvalidDetailsException;
import com.ecommerce.product.exception.ProductNotFoundException;
import com.ecommerce.product.service.ProductService;

@RestController
@RequestMapping("/ecommerce/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("")
	public ResponseEntity<List<ProductOutDto>> getAllProducts() throws ProductNotFoundException
	{
		LOGGER.info("Get all products started.");
		List<ProductOutDto> productOutDtoList = productService.getAllProducts();
		LOGGER.info("Get all products completed.");
		return ResponseEntity.status(HttpStatus.OK).body(productOutDtoList);
		
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<ProductOutDto> AddProduct(@RequestBody ProductInDto productInDto,@PathVariable Long userId) throws InvalidDetailsException
	{
		LOGGER.info("Request Received to create a product");
		ProductOutDto productOutDto = productService.createProduct(productInDto,userId);
		LOGGER.info("Request Completed to cretae a product.");
		return ResponseEntity.status(HttpStatus.OK).body(productOutDto);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductInDto productInDto,@PathVariable String productId) throws ProductNotFoundException
	{
		LOGGER.info("Request Received to update a product for Id : {}",productId);
		ProductOutDto productOutDto = productService.updateProduct(productInDto,productId);
		LOGGER.info("Request Completed to update a product for Id : {}",productId);
		
		return ResponseEntity.status(HttpStatus.OK).body("project updated successfully.");
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable final String productId) throws ProductNotFoundException
	{
		LOGGER.info("Request Received to delete the product for Id : {}",productId);
		productService.deleteProduct(productId);
		LOGGER.info("Request Completed to update a product for Id : {}",productId);
		
		return ResponseEntity.status(HttpStatus.OK).body("project deleted successfully.");
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductOutDto> getProductById(@PathVariable final String productId) throws ProductNotFoundException
	{
		LOGGER.info("Request Received to get a product by Id : {}",productId);
		ProductOutDto productOutDto = productService.getProductById(productId);
		LOGGER.info("Request Completed to get a product by Id : {}",productId);
		return ResponseEntity.status(HttpStatus.OK).body(productOutDto);
	}
}
