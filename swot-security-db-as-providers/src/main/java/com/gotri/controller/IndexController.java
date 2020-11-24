package com.gotri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping(value = "/")
	public ModelAndView getLandingUIForGuest() {		
		return new ModelAndView("index");		
	}
	
	@GetMapping(value = "/secure")
	public ModelAndView getLandingUIForAdmin() {		
		return new ModelAndView("index");		
	}

}
