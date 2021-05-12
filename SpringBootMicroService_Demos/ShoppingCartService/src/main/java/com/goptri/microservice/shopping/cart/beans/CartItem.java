package com.goptri.microservice.shopping.cart.beans;

import java.math.BigDecimal;
import java.math.BigInteger;


public class CartItem {
	
	private long id;
	private String name;
	private String brand;
	private BigDecimal price;
	private BigDecimal quantity;
	private BigDecimal itemValue;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(long id, String name, String brand, BigDecimal price, BigDecimal quantity, BigDecimal itemValue) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.itemValue = itemValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getItemValue() {
		return itemValue;
	}

	public void setItemValue(BigDecimal itemValue) {
		this.itemValue = itemValue;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", quantity="
				+ quantity + ", itemValue=" + itemValue + "]";
	}

	
}
