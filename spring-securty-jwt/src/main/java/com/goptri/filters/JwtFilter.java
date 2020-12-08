package com.goptri.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.goptri.service.MyUserDetailsService;
import com.goptri.utility.JwtUtility;

import io.jsonwebtoken.Claims;


@Component
public class JwtFilter extends OncePerRequestFilter implements Filter {
	
	@Autowired
	MyUserDetailsService userdetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")) {
			String encodejwt = authorizationHeader.substring(7);
			Claims decodeJWT = JwtUtility.decodeJWT(encodejwt);
			
			if(decodeJWT.get("jti") != null && SecurityContextHolder.getContext().getAuthentication()==null && !decodeJWT.getExpiration().before(new Date())) {
				UserDetails userDetails = userdetailsService.loadUserByUsername(decodeJWT.getId());
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}			
		}		
		filterChain.doFilter(request, response);		
	}
}
