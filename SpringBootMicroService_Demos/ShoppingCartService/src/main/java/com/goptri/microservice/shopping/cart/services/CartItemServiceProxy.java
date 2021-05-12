package com.goptri.microservice.shopping.cart.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.goptri.microservice.shopping.cart.beans.CartItem;
import com.goptri.microservice.shopping.cart.beans.CartServiceInfo;


//@FeignClient(name = "product-service",url = "localhost:8082")
@FeignClient(name = "product-service")
@RibbonClient(name = "product-service")
public interface CartItemServiceProxy {
	
	@GetMapping("/products/id/{id}")
	CartServiceInfo retrieveByProductId(@PathVariable long id);
}
