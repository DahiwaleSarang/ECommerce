package com.ecommerce.cart.exception;

public class InsufficientQuantityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372205252469329983L;
	
	public InsufficientQuantityException(String message) {

		super(message);
	}

}
