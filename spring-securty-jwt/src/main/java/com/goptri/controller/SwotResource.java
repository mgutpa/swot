package com.goptri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goptri.model.AuthenticationRequest;
import com.goptri.model.AuthenticationResponse;
import com.goptri.service.MyUserDetailsService;
import com.goptri.utility.JwtUtility;

@RestController
public class SwotResource {
	
	@Autowired
	AuthenticationManager auth;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello protector";		
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			auth.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
					authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Enter credentails is wrong");
		}
		
		String jwt = JwtUtility.createJWT(authenticationRequest.getUsername(), "MKG", "JWT-Tut", 800000);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}
