package com.ecommerce.user.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

public class UserInDtoTest {
	
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

    @Test
    public void testHashCodeAndEquals() {
        UserInDto user1 = createUserInDtoObj();
        UserInDto user2 = createUserInDtoObj();

        Assertions.assertEquals(user1.hashCode(), user2.hashCode());
        Assertions.assertEquals(user1, user2);
    }

    @Test
    public void testGettersAndSetters() {
    	
        UserInDto userInDto = new UserInDto();
        
        assertNull(userInDto.getFirstName());
        userInDto.setFirstName(firstName);
        assertEquals(userInDto.getFirstName(), firstName);

        assertNull(userInDto.getLastName());
        userInDto.setLastName(lastName);
        assertEquals(userInDto.getLastName(), lastName);
        
        assertNull(userInDto.getAddressLine1());
        userInDto.setAddressLine1(addressLine1);
        assertEquals(userInDto.getAddressLine1(), addressLine1);
        
        assertNull(userInDto.getAddressLine2());
        userInDto.setAddressLine2(addressLine2);
        assertEquals(userInDto.getAddressLine2(), addressLine2);
        
        assertNull(userInDto.getCity());
        userInDto.setCity(city);
        assertEquals(userInDto.getCity(), city);
        
        assertNull(userInDto.getCountry());
        userInDto.setCountry(country);
        assertEquals(userInDto.getCountry(), country);
        
        assertNull(userInDto.getCountryCode());
        userInDto.setCountryCode(countryCode);
        assertEquals(userInDto.getCountryCode(), countryCode);
        
        assertNull(userInDto.getPostalCode());
        userInDto.setPostalCode(postalCode);
        assertEquals(userInDto.getPostalCode() , postalCode);
        
        assertNull(userInDto.getEmail());
        userInDto.setEmail(email);
        assertEquals(userInDto.getEmail(), email);
        
        assertNull(userInDto.getGender());
        userInDto.setGender(gender);
        assertEquals(userInDto.getGender(), gender);
        
        assertNull(userInDto.getPhone());
        userInDto.setPhone(phone);
        assertEquals(userInDto.getPhone(), phone);
        
        assertNull(userInDto.getRole());
        userInDto.setRole(role);
        assertEquals(userInDto.getRole(), role);
        
        assertNull(userInDto.getState());
        userInDto.setState(state);
        assertEquals(userInDto.getState(), state);
    }

    @Test
    public void testDefaultConstructor() {
        UserInDto user = new UserInDto();
        Assertions.assertNull(user.getFirstName());
        Assertions.assertNull(user.getLastName());
        Assertions.assertNull(user.getGender());
        Assertions.assertNull(user.getPhone());
        Assertions.assertNull(user.getCountryCode());
        Assertions.assertNull(user.getEmail());
        Assertions.assertNull(user.getAddressLine1());
        Assertions.assertNull(user.getAddressLine2());
        Assertions.assertNull(user.getCity());
        Assertions.assertNull(user.getState());
        Assertions.assertNull(user.getCountry());
        Assertions.assertNull(user.getPostalCode());
        Assertions.assertNull(user.getRole());
    }

    @Test
    public void testParameterizedConstructor() {
        
        UserInDto user = new UserInDto(firstName,lastName,gender,phone,countryCode,email,addressLine1,addressLine2,city,state,country,postalCode,role);

        Assertions.assertEquals(firstName, user.getFirstName());
        Assertions.assertEquals(lastName, user.getLastName());
        Assertions.assertEquals(gender, user.getGender());
        Assertions.assertEquals(phone, user.getPhone());
        Assertions.assertEquals(countryCode, user.getCountryCode());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(addressLine1, user.getAddressLine1());
        Assertions.assertEquals(addressLine2, user.getAddressLine2());
        Assertions.assertEquals(city, user.getCity());
        Assertions.assertEquals(state, user.getState());
        Assertions.assertEquals(country, user.getCountry());
        Assertions.assertEquals(postalCode, user.getPostalCode());
        Assertions.assertEquals(role, user.getRole());
        
    }

    @Test
    public void testObjectComparison() {
        UserInDto user1 = new UserInDto();
        UserInDto user2 = new UserInDto();

        Assertions.assertNotSame(user1, user2);

        UserInDto user3 = user1;

        Assertions.assertSame(user1, user3);
    }
 
    private UserInDto createUserInDtoObj()
    {
    	UserInDto userInDto = new UserInDto();
    	
    	userInDto.setFirstName("sarang");
    	userInDto.setLastName("dahiwale");
    	userInDto.setGender("male");
    	userInDto.setPostalCode("480334");
    	userInDto.setPhone("9156482811");
    	userInDto.setRole("buyer");
    	userInDto.setState("madhya pradesh");
    	userInDto.setEmail("sarang.dahiwale@gmail.com");
    	userInDto.setAddressLine1("3,Radha Krishna Ward Pandhurna");
    	userInDto.setAddressLine2("3,Radha Krishna Ward Pandhurna");
    	userInDto.setCountry("india");
    	userInDto.setCountryCode("+91");
    	
    	return userInDto;
    }
}

