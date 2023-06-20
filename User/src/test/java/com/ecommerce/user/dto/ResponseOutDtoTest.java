package com.ecommerce.user.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResponseOutDtoTest {

	String message = "test message";
	
	  @Test
	     public void testHashCodeAndEquals() {
	         ResponseOutDto responseOutDto1 = createResponseOutDtoObj();
	         ResponseOutDto responseOutDto2 = createResponseOutDtoObj();

	         Assertions.assertEquals(responseOutDto1.hashCode(), responseOutDto2.hashCode());
	         Assertions.assertEquals(responseOutDto1, responseOutDto2);
	     }

	     @Test
	     public void testGettersAndSetters() {
	     	
	    	 ResponseOutDto responseOutDto = new ResponseOutDto();
	         
	         assertNull(responseOutDto.getMessage());
	         responseOutDto.setMessage(message);
	         assertEquals(responseOutDto.getMessage(), message);

	     }

	     @Test
	     public void testDefaultConstructor() {
	    	 ResponseOutDto responseOutDto = new ResponseOutDto();
	         Assertions.assertNull(responseOutDto.getMessage());
	        
	     }

	     @Test
	     public void testParameterizedConstructor() {
	         
	    	 ResponseOutDto responseOutDto = new ResponseOutDto(message);

	         Assertions.assertEquals(message, responseOutDto.getMessage());
	      
	     }

	     @Test
	     public void testObjectComparison() {
	    	 ResponseOutDto responseOutDto1 = new ResponseOutDto();
	    	 ResponseOutDto responseOutDto2 = new ResponseOutDto();

	         Assertions.assertNotSame(responseOutDto1, responseOutDto2);

	         ResponseOutDto responseOutDto3 = responseOutDto1;

	         Assertions.assertSame(responseOutDto1, responseOutDto3);
	     }
	  
	     private ResponseOutDto createResponseOutDtoObj()
	     {
	    	 ResponseOutDto responseOutDto = new ResponseOutDto();
	     	 responseOutDto.setMessage(message);
	     	
	     	return responseOutDto;
	     }

}
