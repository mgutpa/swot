package com.goptri.microservice.shopping.cart.beans;


public class CartServiceInfo {
	
	CartItem product;
	int serverPort;
	
	public CartServiceInfo() {
		// TODO Auto-generated constructor stub
	}

	public CartServiceInfo(CartItem product, int serverPort) {
		super();
		this.product = product;
		this.serverPort = serverPort;
	}

	public CartItem getProduct() {
		return product;
	}

	public int getServerPort() {
		return serverPort;
	}

	@Override
	public String toString() {
		return "CartServiceInfo [product=" + product + ", serverPort=" + serverPort + "]";
	}

	
}
