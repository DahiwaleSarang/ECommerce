package com.ecommerce.user.service;

import java.time.Instant;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.constant.Constants;
import com.ecommerce.user.dto.ResponseOutDto;
import com.ecommerce.user.dto.SignUpInDto;
import com.ecommerce.user.dto.UserInDto;
import com.ecommerce.user.dto.UserOutDto;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.exception.UserExistsException;
import com.ecommerce.user.exception.UserNotFoundException;
import com.ecommerce.user.repository.UserRepository;
import com.ecommerce.user.utils.CryptoUtils;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	ModelMapper mapper =new ModelMapper();
	
	public UserOutDto updateUserDetails(UserInDto userInDto,Long id) throws UserNotFoundException
	{
		Optional<User> findById = userRepository.findById(id);
		if(!findById.isPresent())
			throw new UserNotFoundException(Constants.USER_NOT_FOUND);
		User user = findById.get();
		user = setUserByUserInDto(userInDto,user);
		User savedUser = userRepository.save(user);
		UserOutDto userOutDto = mapper.map(savedUser, UserOutDto.class);
		
		return userOutDto;
	}

	private User setUserByUserInDto(UserInDto userInDto, User user) {
		
		user.setFirstName(userInDto.getFirstName());
		user.setLastName(userInDto.getLastName());
		user.setAddressLine1(userInDto.getAddressLine1());
		user.setAddressLine2(userInDto.getAddressLine2());
		user.setCity(userInDto.getCity());
		user.setCountry(userInDto.getCountry());
		user.setEmail(userInDto.getEmail());
		user.setCountryCode(userInDto.getCountryCode());
		user.setPhone(userInDto.getPhone());
		user.setPostalCode(userInDto.getPostalCode());
		user.setState(userInDto.getState());
		user.setUpdatedDate(Instant.now());
		return user;
	}

	public UserOutDto getUserDetails(Long id) throws UserNotFoundException{
		
		Optional<User> findById = userRepository.findById(id);
		if(findById.isPresent())
		{
			User user =  findById.get();
			return mapper.map(user, UserOutDto.class);
		}
		else
		{
			throw new UserNotFoundException(Constants.USER_NOT_FOUND);
		}
	}

	public UserOutDto createUser(SignUpInDto userInDto) throws UserExistsException {
		Optional<User> existingUser = userRepository.findByEmail(userInDto.getEmail());
		if(existingUser.isPresent())
			throw new UserExistsException(String.format(Constants.USER_ALREADY_EXISTS , userInDto.getEmail().toLowerCase()));
		
		User user = mapper.map(userInDto, User.class);
		user.setPassword(CryptoUtils.secureHash(userInDto.getPassword()));
		user.setCreatedDt(Instant.now());
		user.setUpdatedDate(Instant.now());
		User createdUser = userRepository.save(user);
		return mapper.map(createdUser, UserOutDto.class);
	}

	public ResponseOutDto deleteUser(Long userId) {
		
		userRepository.deleteById(userId);
		ResponseOutDto responseOutDto =new ResponseOutDto();
		responseOutDto.setMessage(Constants.USER_DELETED);
		return responseOutDto;
	}
}
