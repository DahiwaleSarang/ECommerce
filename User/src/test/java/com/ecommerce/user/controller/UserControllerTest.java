package com.ecommerce.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ecommerce.user.constant.Constants;
import com.ecommerce.user.dto.ResponseOutDto;
import com.ecommerce.user.dto.SignUpInDto;
import com.ecommerce.user.dto.UserInDto;
import com.ecommerce.user.dto.UserOutDto;
import com.ecommerce.user.exception.UserExistsException;
import com.ecommerce.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	
	@Mock
	UserService userService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);

    }
    
    public void SignUpUserTest() throws Exception
    {
    	MockitoAnnotations.openMocks(this);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        
        SignUpInDto signUpInDto = createSignUpInDto();
        
        UserOutDto userOutDto = createUserOutDto();
        String inputJSON = objectMapper.writeValueAsString(signUpInDto);
        when(userService.createUser(signUpInDto)).thenReturn(userOutDto);
        MvcResult mvcResult = mockMvc
                .perform(post("/ecommerce/user").contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), responseStatus);
        
    }
    
    @Test
    public void getUserDetailsTest() throws Exception {

        MockitoAnnotations.openMocks(this);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        Long userId = 1L;	

        UserOutDto signupOutDtoTest = createUserOutDto();

        when(userService.getUserDetails(userId)).thenReturn(signupOutDtoTest);

        MvcResult mvcResult = mockMvc.perform(get("/ecommerce/user/1").contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), responseStatus);

    }

    @Test
    public void updateUserDetailsTest() throws Exception {

        MockitoAnnotations.openMocks(this);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        

        UserOutDto signupOutDtoTest = createUserOutDto();

        UserInDto updateUserInDtoTest = buildUpdateUserInDto();
        Long userId = 1L;
        	
        String inputJSON = objectMapper.writeValueAsString(updateUserInDtoTest);
        when(userService.updateUserDetails(updateUserInDtoTest , userId)).thenReturn(signupOutDtoTest);

        MvcResult mvcResult = mockMvc
                .perform(put("/ecommerce/user/1").contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), responseStatus);

    }

   

    @Test
    public void deleteUserTest() throws Exception {

        MockitoAnnotations.openMocks(this);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        Long userId = 1L;

        ResponseOutDto responseOutDto = new ResponseOutDto();
        responseOutDto.setMessage(Constants.USER_DELETED);

        when(userService.deleteUser(userId)).thenReturn(responseOutDto);

        MvcResult mvcResult = mockMvc.perform(delete("/ecommerce/user/1").contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), responseStatus);

    }
    
 

    public UserInDto buildUpdateUserInDto() {

    	String firstName = "sarang";
        String lastName = "dahiwale";
        String gender = "male";
        String phone = "9156482811";
        String countryCode = "+91";
        String email = "sd@nucleusteq.com";
        String addressLine1 = "bhamori indore";
        String addressLine2 = "bhamori 2 indore";
        String city = "indore";
        String state = "madhya pradesh";
        String country = "india";
        String postalCode = "452001";
        String role = "role";
        
        UserInDto updateUserInDtoTest = new UserInDto();
        updateUserInDtoTest.setAddressLine1(addressLine1);
        updateUserInDtoTest.setAddressLine2(addressLine2);
        updateUserInDtoTest.setCity(city);
        updateUserInDtoTest.setCountry(country);
        updateUserInDtoTest.setCountryCode(countryCode);
        updateUserInDtoTest.setEmail(email);
        updateUserInDtoTest.setFirstName(firstName);
        updateUserInDtoTest.setGender(gender);
        updateUserInDtoTest.setLastName(lastName);
        updateUserInDtoTest.setPhone(phone);
        updateUserInDtoTest.setPostalCode(postalCode);
        updateUserInDtoTest.setRole(role);
        updateUserInDtoTest.setState(state);
        return updateUserInDtoTest;
    }

	
	private UserOutDto createUserOutDto() {
		 Long id = 1L;
		 String firstName = "sarang";
	     String lastName = "dahiwale";
	     String gender = "male";
	     String phone = "9156482811";
	     String countryCode = "+91";
	     String email = "sd@nucleusteq.com";
	     String addressLine1 = "bhamori indore";
	     String addressLine2 = "bhamori 2 indore";
	     String city = "indore";
	     String state = "madhya pradesh";
	     String country = "india";
	     String postalCode = "452001";
	     String role = "role";
	     Instant createdDt = Instant.now();
		
	     UserOutDto userOutDto = new UserOutDto();
	     userOutDto.setId(id);
    	 userOutDto.setFirstName(firstName);
    	 userOutDto.setLastName(lastName);
    	 userOutDto.setGender(gender);
    	 userOutDto.setPostalCode(postalCode);
    	 userOutDto.setPhone(phone);
    	 userOutDto.setRole(role);
    	 userOutDto.setState(state);
    	 userOutDto.setEmail(email);
    	 userOutDto.setAddressLine1(addressLine1);
    	 userOutDto.setAddressLine2(addressLine2);
    	 userOutDto.setCountry(country);
    	 userOutDto.setCountryCode(countryCode);
     	 userOutDto.setCreatedDt(createdDt);
     	return userOutDto;
	}

	private SignUpInDto createSignUpInDto()
    {
    	SignUpInDto signUpInDto = new SignUpInDto();
    	
    	signUpInDto.setFirstName("sarang");
    	signUpInDto.setLastName("dahiwale");
    	signUpInDto.setGender("male");
    	signUpInDto.setPostalCode("480334");
    	signUpInDto.setPhone("9156482811");
    	signUpInDto.setRole("buyer");
    	signUpInDto.setState("madhya pradesh");
    	signUpInDto.setEmail("sarang.dahiwale@gmail.com");
    	signUpInDto.setAddressLine1("3,Radha Krishna Ward Pandhurna");
    	signUpInDto.setAddressLine2("3,Radha Krishna Ward Pandhurna");
    	signUpInDto.setCountry("india");
    	signUpInDto.setCountryCode("+91");
    	signUpInDto.setPassword(new char[]{'s', 'a', 'r', 'a', 'n', 'g', '@', '1', '2', '3'});
    	
    	return signUpInDto;
    }
}

