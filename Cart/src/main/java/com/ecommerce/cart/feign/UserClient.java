package com.ecommerce.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.cart.dto.UserOutDto;

@FeignClient(value="user", url="http://localhost:8080/ecommerce/user")
public interface UserClient {
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserOutDto> getUserDetails(@PathVariable("userId") Long userId);

}
