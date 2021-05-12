package com.goptri.microservice.shopping.cart.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.goptri.microservice.shopping.cart.beans.CartItem;
import com.goptri.microservice.shopping.cart.beans.CartServiceInfo;


@RequestMapping("/shopping-cart-rest")
@RestController
public class ShoppingCartController {
	
	
	
	@GetMapping("/item-id/{id}/quantity/{quantity}")
	public CartServiceInfo retrieveCartItem(@PathVariable long id,@PathVariable BigDecimal quantity) {
		
		String url = "http://localhost:8082/products/id/{id}";
		Map<String,Long> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		ResponseEntity<CartServiceInfo> response = 
				new RestTemplate().getForEntity(url, CartServiceInfo.class, uriVariables);
		
		CartServiceInfo cartServiceInfo = response.getBody();
		System.out.println(cartServiceInfo);
		CartItem cartItem = cartServiceInfo.getProduct();
		BigDecimal itemValue = quantity.multiply(cartItem.getPrice());
		
		CartItem item = new CartItem(cartItem.getId(), cartItem.getName(), cartItem.getBrand(), cartItem.getPrice(), quantity, itemValue);
	
		return new  CartServiceInfo(item, cartServiceInfo.getServerPort());
	}
}
