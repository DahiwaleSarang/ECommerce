package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserOutDtoTest {
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
     
     @Test
     public void testHashCodeAndEquals() {
         UserOutDto user1 = createuserOutDtoObj();
         UserOutDto user2 = createuserOutDtoObj();

         Assertions.assertEquals(user1.hashCode(), user2.hashCode());
         Assertions.assertEquals(user1, user2);
     }

     @Test
     public void testGettersAndSetters() {
     	
    	 UserOutDto userOutDto = new UserOutDto();
         

         assertNull(userOutDto.getId());
         userOutDto.setId(id);
         assertEquals(userOutDto.getId(), id);
         
         assertNull(userOutDto.getFirstName());
         userOutDto.setFirstName(firstName);
         assertEquals(userOutDto.getFirstName(), firstName);

         assertNull(userOutDto.getLastName());
         userOutDto.setLastName(lastName);
         assertEquals(userOutDto.getLastName(), lastName);
         
         assertNull(userOutDto.getAddressLine1());
         userOutDto.setAddressLine1(addressLine1);
         assertEquals(userOutDto.getAddressLine1(), addressLine1);
         
         assertNull(userOutDto.getAddressLine2());
         userOutDto.setAddressLine2(addressLine2);
         assertEquals(userOutDto.getAddressLine2(), addressLine2);
         
         assertNull(userOutDto.getCity());
         userOutDto.setCity(city);
         assertEquals(userOutDto.getCity(), city);
         
         assertNull(userOutDto.getCountry());
         userOutDto.setCountry(country);
         assertEquals(userOutDto.getCountry(), country);
         
         assertNull(userOutDto.getCountryCode());
         userOutDto.setCountryCode(countryCode);
         assertEquals(userOutDto.getCountryCode(), countryCode);
         
         assertNull(userOutDto.getPostalCode());
         userOutDto.setPostalCode(postalCode);
         assertEquals(userOutDto.getPostalCode() , postalCode);
         
         assertNull(userOutDto.getEmail());
         userOutDto.setEmail(email);
         assertEquals(userOutDto.getEmail(), email);
         
         assertNull(userOutDto.getGender());
         userOutDto.setGender(gender);
         assertEquals(userOutDto.getGender(), gender);
         
         assertNull(userOutDto.getPhone());
         userOutDto.setPhone(phone);
         assertEquals(userOutDto.getPhone(), phone);
         
         assertNull(userOutDto.getRole());
         userOutDto.setRole(role);
         assertEquals(userOutDto.getRole(), role);
         
         assertNull(userOutDto.getState());
         userOutDto.setState(state);
         assertEquals(userOutDto.getState(), state);
         
         assertNull(userOutDto.getCreatedDt());
         userOutDto.setCreatedDt(createdDt);
         assertEquals(userOutDto.getCreatedDt(), createdDt);
     }

     @Test
     public void testDefaultConstructor() {
         UserOutDto user = new UserOutDto();
         Assertions.assertNull(user.getId());
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
         Assertions.assertNull(user.getCreatedDt());
     }

     @Test
     public void testParameterizedConstructor() {
         
         UserOutDto user = new UserOutDto(id,firstName,lastName,gender,phone,countryCode,email,createdDt,addressLine2,city,state,country,postalCode,role,addressLine1);

         Assertions.assertEquals(id, user.getId());
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
         UserOutDto user1 = new UserOutDto();
         UserOutDto user2 = new UserOutDto();

         Assertions.assertNotSame(user1, user2);

         UserOutDto user3 = user1;

         Assertions.assertSame(user1, user3);
     }
  
     private UserOutDto createuserOutDtoObj()
     {
    	 UserOutDto userOutDto = new UserOutDto();
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

}
