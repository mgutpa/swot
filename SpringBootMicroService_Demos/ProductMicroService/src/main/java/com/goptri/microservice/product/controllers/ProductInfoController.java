package com.goptri.microservice.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goptri.microservice.product.beans.ProductServiceInfo;
import com.goptri.microservice.product.entities.Product;
import com.goptri.microservice.product.exceptions.ProductNotFoundException;
import com.goptri.microservice.product.repos.ProductRepository;


@RequestMapping("/products")
@RestController
public class ProductInfoController {
	
	@Autowired
	private Environment env;

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/id/{id}")
	public ProductServiceInfo getProduct(@PathVariable long id) {
		Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry! Product with id " + id + " not found"));
		
		int serverPort = Integer.parseInt(env.getProperty("server.port"));
		
		return new ProductServiceInfo(product, serverPort);
	}
}
