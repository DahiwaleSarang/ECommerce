package com.ecommerce.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.cart.dto.ProductOutDto;



@FeignClient(value="product", url="http://localhost:8081/ecommerce/product")
public interface ProductClient {
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductOutDto> getProductById(@PathVariable("productId") final String productId);

}
