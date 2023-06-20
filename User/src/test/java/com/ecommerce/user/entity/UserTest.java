package com.ecommerce.user.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ecommerce.user.dto.SignUpInDto;

public class UserTest {
	
	  Long id = 100L;
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
      Instant createdDt = Instant.now();
      Instant updatedDate = Instant.now();
      
      
      @Test
      public void testHashCodeAndEquals() {
          User user1 = createUserObj();
          User user2 = createUserObj();

          Assertions.assertEquals(user1.hashCode(), user2.hashCode());
          Assertions.assertEquals(user1, user2);
      }

      @Test
      public void testGettersAndSetters() {
      	
          User user = new User();
          
          assertNull(user.getId());
          user.setId(id);
          assertEquals(user.getId(), id);
          
          assertNull(user.getFirstName());
          user.setFirstName(firstName);
          assertEquals(user.getFirstName(), firstName);

          assertNull(user.getLastName());
          user.setLastName(lastName);
          assertEquals(user.getLastName(), lastName);
          
          assertNull(user.getAddressLine1());
          user.setAddressLine1(addressLine1);
          assertEquals(user.getAddressLine1(), addressLine1);
          
          assertNull(user.getAddressLine2());
          user.setAddressLine2(addressLine2);
          assertEquals(user.getAddressLine2(), addressLine2);
          
          assertNull(user.getCity());
          user.setCity(city);
          assertEquals(user.getCity(), city);
          
          assertNull(user.getCountry());
          user.setCountry(country);
          assertEquals(user.getCountry(), country);
          
          assertNull(user.getCountryCode());
          user.setCountryCode(countryCode);
          assertEquals(user.getCountryCode(), countryCode);
          
          assertNull(user.getPostalCode());
          user.setPostalCode(postalCode);
          assertEquals(user.getPostalCode() , postalCode);
          
          assertNull(user.getEmail());
          user.setEmail(email);
          assertEquals(user.getEmail(), email);
          
          assertNull(user.getGender());
          user.setGender(gender);
          assertEquals(user.getGender(), gender);
          
          assertNull(user.getPhone());
          user.setPhone(phone);
          assertEquals(user.getPhone(), phone);
          
          assertNull(user.getRole());
          user.setRole(role);
          assertEquals(user.getRole(), role);
          
          assertNull(user.getState());
          user.setState(state);
          assertEquals(user.getState(), state);
          
          assertNull(user.getPassword());
          user.setPassword(password);
          assertEquals(user.getPassword(), password);
          
          assertNull(user.getCreatedDt());
          user.setCreatedDt(createdDt);
          assertEquals(user.getCreatedDt(), createdDt);
          
          assertNull(user.getUpdatedDate());
          user.setUpdatedDate(updatedDate);
          assertEquals(user.getUpdatedDate(), updatedDate);
      }

      @Test
      public void testDefaultConstructor() {
          User user = new User();
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
          Assertions.assertNull(user.getPassword());
          Assertions.assertNull(user.getCreatedDt());
          Assertions.assertNull(user.getUpdatedDate());
      }

      @Test
      public void testParameterizedConstructor() {
          
          User user = new User(id,firstName,lastName,gender,phone,countryCode,email,createdDt,addressLine1,addressLine2,city,state,country,postalCode,role,password,updatedDate);
          
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
          Assertions.assertEquals(password, user.getPassword());
          Assertions.assertEquals(createdDt, user.getCreatedDt());
          Assertions.assertEquals(updatedDate, user.getUpdatedDate());
      }

      @Test
      public void testObjectComparison() {
          SignUpInDto user1 = new SignUpInDto();
          SignUpInDto user2 = new SignUpInDto();

          Assertions.assertNotSame(user1, user2);

          SignUpInDto user3 = user1;

          Assertions.assertSame(user1, user3);
      }
   
      private User createUserObj()
      {
      	User user = new User();
      	user.setId(100L);
      	user.setFirstName("sarang");
      	user.setLastName("dahiwale");
      	user.setGender("male");
      	user.setPostalCode("480334");
      	user.setPhone("9156482811");
      	user.setRole("buyer");
      	user.setState("madhya pradesh");
      	user.setEmail("sarang.dahiwale@gmail.com");
      	user.setAddressLine1("3,Radha Krishna Ward Pandhurna");
      	user.setAddressLine2("3,Radha Krishna Ward Pandhurna");
      	user.setCountry("india");
      	user.setCountryCode("+91");
      	user.setPassword(new char[]{'s', 'a', 'r', 'a', 'n', 'g', '@', '1', '2', '3'});
      	user.setCreatedDt(Instant.now());
      	user.setUpdatedDate(Instant.now());
      	return user;
      }

}
