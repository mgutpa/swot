package com.goptri.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class ShoppingApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiGatewayServiceApplication.class, args);
	}

}
