package com.gotri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/secure/admin")
	public String admin() {
		return "<h1> Welcome Admin </h1>";
	}
	
	@GetMapping("/secure/user")
	public String user() {
		return "<h1> Welcome User </h1>";
	}
	
}
