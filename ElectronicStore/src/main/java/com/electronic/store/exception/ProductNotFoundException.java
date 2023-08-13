package com.electronic.store.exception;



public class ProductNotFoundException extends RuntimeException{

	
	public ProductNotFoundException() {
		super();		
	}
	
	public ProductNotFoundException(String customMessage) {
		super(customMessage);		
	}

	
	
	
}
