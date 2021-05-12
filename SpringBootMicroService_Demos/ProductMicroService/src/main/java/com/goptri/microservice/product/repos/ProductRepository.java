package com.goptri.microservice.product.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goptri.microservice.product.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(BigDecimal price);
	
	List<Product> findByNameAndBrand(String name,String brand);
	List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
