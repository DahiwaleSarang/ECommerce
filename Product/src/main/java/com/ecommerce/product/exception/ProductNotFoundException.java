package com.ecommerce.product.exception;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7270050591969453138L;

	/**
     * @param message - The message to be send in the exception.
     */
    public ProductNotFoundException(final String message) {
        super(message);
    }
}
