package com.goptri.microservice.product.exceptions;


public class ProductNotFoundException extends RuntimeException {

	private String message;
	
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProductNotFoundException [message=" + message + "]";
	}
	
	
}
