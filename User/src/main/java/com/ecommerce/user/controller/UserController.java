package com.ecommerce.user.controller;

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

import com.ecommerce.user.dto.ResponseOutDto;
import com.ecommerce.user.dto.SignUpInDto;
import com.ecommerce.user.dto.UserInDto;
import com.ecommerce.user.dto.UserOutDto;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.exception.UserExistsException;
import com.ecommerce.user.exception.UserNotFoundException;
import com.ecommerce.user.service.UserService;

@RestController
@RequestMapping("/ecommerce/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	 /**
     * The logger variable to log information or errors related to UserController
     * class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PutMapping("{Id}")
	public ResponseEntity<UserOutDto> updateUser(@RequestBody UserInDto userInDto, @PathVariable("Id") final Long id) throws UserNotFoundException {
		LOGGER.info("request received to update user details for user Id : {}",id);
		UserOutDto updatedUser = userService.updateUserDetails(userInDto, id);
		LOGGER.info("user details updated for user Id : {}",id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	
	@GetMapping("{Id}")
	public ResponseEntity<UserOutDto> getUserDetails(@PathVariable("Id") Long id) throws UserNotFoundException 
	{
		LOGGER.info("request received to get user details for user Id : {}",id);
		UserOutDto updatedUser = userService.getUserDetails(id);
		LOGGER.info("user details fetched for user Id : {}",id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	
	@PostMapping("")
	public ResponseEntity<UserOutDto> SignUpUser(@RequestBody SignUpInDto signUpInDto) throws UserNotFoundException, UserExistsException 
	{
		LOGGER.info("request received to create new user");
		UserOutDto createdUser = userService.createUser(signUpInDto);
		LOGGER.info("user created  with user Id : {}",createdUser.getId());
		return ResponseEntity.status(HttpStatus.OK).body(createdUser);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<ResponseOutDto> deleteUser(@PathVariable final Long userId)
	{

		LOGGER.info("request received to delete a user for Id : {}",userId);
		ResponseOutDto responseOutDto= userService.deleteUser(userId);
		LOGGER.info("request completed to delete a user for Id : {}",userId);
		return ResponseEntity.status(HttpStatus.OK).body(responseOutDto);
	}
	
}
