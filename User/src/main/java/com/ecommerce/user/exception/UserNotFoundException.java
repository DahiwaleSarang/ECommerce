package com.ecommerce.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserNotFoundException class for handling exception when user is not found in
 * our system.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

	   /**
     * Serial version id.
     */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param message contains the message due to which exception occured
     * */
    public UserNotFoundException(final String message) {
        super(message);
    }
}
