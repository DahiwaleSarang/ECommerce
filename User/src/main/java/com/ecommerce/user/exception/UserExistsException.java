package com.ecommerce.user.exception;

public class UserExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1685711645414180689L;
	
	public UserExistsException(String message)
	{
		super(message);
	}

}
