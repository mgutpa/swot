package com.goptri.microservice.shopping.cart.controllers;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goptri.microservice.shopping.cart.beans.CartItem;
import com.goptri.microservice.shopping.cart.beans.CartServiceInfo;
import com.goptri.microservice.shopping.cart.services.CartItemServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RequestMapping("/shopping-cart")
@RestController
public class ShoppingCartFeignController {
	
	@Autowired
	private CartItemServiceProxy serviceProxy;
	
	//@HystrixCommand(fallbackMethod = "fallback")
	
	  @HystrixCommand( fallbackMethod = "fallback", commandProperties = { 
	  // if 1000ms of time passes, the method "fallback" will be executed
	  @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds",
	  value = "1000") })
	 
	@GetMapping("/item-id/{id}/quantity/{quantity}")
	public CartServiceInfo retrieveCartItem(@PathVariable long id,@PathVariable BigDecimal quantity) {
		
		CartServiceInfo cartServiceInfo = serviceProxy.retrieveByProductId(id);
		System.out.println(cartServiceInfo);
		CartItem cartItem = cartServiceInfo.getProduct();
		BigDecimal itemValue = quantity.multiply(cartItem.getPrice());
		
		CartItem item = new CartItem(cartItem.getId(), cartItem.getName(), cartItem.getBrand(), cartItem.getPrice(), quantity, itemValue);
	
		return new  CartServiceInfo(item, cartServiceInfo.getServerPort());
	}

	// a fallback method to be called if failure happened
	public CartServiceInfo fallback(long id,BigDecimal quantity,Throwable hystrixCommand) {
		return new CartServiceInfo();
		//throw new RuntimeException("Service Unavailable");
	}
}
