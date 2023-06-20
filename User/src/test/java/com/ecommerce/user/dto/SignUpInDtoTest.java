package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignUpInDtoTest {
	
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
     char[] password = new char[]{'s', 'a', 'r', 'a', 'n', 'g', '@', '1', '2', '3'};
     @Test
     public void testHashCodeAndEquals() {
         SignUpInDto user1 = createsignUpInDtoObj();
         SignUpInDto user2 = createsignUpInDtoObj();

         Assertions.assertEquals(user1.hashCode(), user2.hashCode());
         Assertions.assertEquals(user1, user2);
     }

     @Test
     public void testGettersAndSetters() {
     	
         SignUpInDto signUpInDto = new SignUpInDto();
         
         assertNull(signUpInDto.getFirstName());
         signUpInDto.setFirstName(firstName);
         assertEquals(signUpInDto.getFirstName(), firstName);

         assertNull(signUpInDto.getLastName());
         signUpInDto.setLastName(lastName);
         assertEquals(signUpInDto.getLastName(), lastName);
         
         assertNull(signUpInDto.getAddressLine1());
         signUpInDto.setAddressLine1(addressLine1);
         assertEquals(signUpInDto.getAddressLine1(), addressLine1);
         
         assertNull(signUpInDto.getAddressLine2());
         signUpInDto.setAddressLine2(addressLine2);
         assertEquals(signUpInDto.getAddressLine2(), addressLine2);
         
         assertNull(signUpInDto.getCity());
         signUpInDto.setCity(city);
         assertEquals(signUpInDto.getCity(), city);
         
         assertNull(signUpInDto.getCountry());
         signUpInDto.setCountry(country);
         assertEquals(signUpInDto.getCountry(), country);
         
         assertNull(signUpInDto.getCountryCode());
         signUpInDto.setCountryCode(countryCode);
         assertEquals(signUpInDto.getCountryCode(), countryCode);
         
         assertNull(signUpInDto.getPostalCode());
         signUpInDto.setPostalCode(postalCode);
         assertEquals(signUpInDto.getPostalCode() , postalCode);
         
         assertNull(signUpInDto.getEmail());
         signUpInDto.setEmail(email);
         assertEquals(signUpInDto.getEmail(), email);
         
         assertNull(signUpInDto.getGender());
         signUpInDto.setGender(gender);
         assertEquals(signUpInDto.getGender(), gender);
         
         assertNull(signUpInDto.getPhone());
         signUpInDto.setPhone(phone);
         assertEquals(signUpInDto.getPhone(), phone);
         
         assertNull(signUpInDto.getRole());
         signUpInDto.setRole(role);
         assertEquals(signUpInDto.getRole(), role);
         
         assertNull(signUpInDto.getState());
         signUpInDto.setState(state);
         assertEquals(signUpInDto.getState(), state);
         
         assertNull(signUpInDto.getPassword());
         signUpInDto.setPassword(password);
         assertEquals(signUpInDto.getPassword(), password);
     }

     @Test
     public void testDefaultConstructor() {
         SignUpInDto user = new SignUpInDto();
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
         Assertions.assertNull(user.getPassword());
     }

     @Test
     public void testParameterizedConstructor() {
         
         SignUpInDto user = new SignUpInDto(firstName,lastName,gender,phone,countryCode,email,addressLine1,addressLine2,city,state,country,postalCode,role,password);

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
         Assertions.assertEquals(password, user.getPassword());
     }

     @Test
     public void testObjectComparison() {
         SignUpInDto user1 = new SignUpInDto();
         SignUpInDto user2 = new SignUpInDto();

         Assertions.assertNotSame(user1, user2);

         SignUpInDto user3 = user1;

         Assertions.assertSame(user1, user3);
     }
  
     private SignUpInDto createsignUpInDtoObj()
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
