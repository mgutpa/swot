package com.goptri.microservice.product.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {

	@Id
	private long id;
	
	@Column(length =  50)
	private String name;
	
	@Column(length = 40)
	private String brand;
	
	@Column(precision = 14, scale = 2)
	private BigDecimal price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, String brand, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
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

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
