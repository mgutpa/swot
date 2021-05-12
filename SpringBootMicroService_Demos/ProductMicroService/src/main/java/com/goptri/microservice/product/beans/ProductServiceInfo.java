package com.goptri.microservice.product.beans;

import com.goptri.microservice.product.entities.Product;


public class ProductServiceInfo {
	
	private Product product;
	private int serverPort;
	
	public ProductServiceInfo() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceInfo(Product product, int serverPort) {
		super();
		this.product = product;
		this.serverPort = serverPort;
	}

	public Product getProduct() {
		return product;
	}

	public int getServerPort() {
		return serverPort;
	}

	@Override
	public String toString() {
		return "ProductServiceInfo [product=" + product + ", serverPort=" + serverPort + "]";
	}
}
