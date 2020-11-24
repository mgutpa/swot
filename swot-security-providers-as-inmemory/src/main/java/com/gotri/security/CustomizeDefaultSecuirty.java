package com.gotri.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class CustomizeDefaultSecuirty extends WebSecurityConfigurerAdapter {
	
	
	/**
	 * Behind the seen, its filter DelegatingFilterProxy which does the bootstrapping. URL pattern by default is "/*"
	 * When user enters credentials, its credential is added inside authentication object and it goes to the authenticate method
	 * Authentication provider. This methods validates the shared credentials against the DB/InMemory/LDAP entries and return
	 * the same authentication object along with principal information. Since their can be many providers, so AuthenticationManager
	 * does the delegation part to appropriate provider. Provider do have a supports() methods to tell the manager the type of 
	 * authentication, it is supporting. Provider calls UserDetailsService.loadUserByName by passing username to it which inturn
	 * return the userDetails ( Has getAuthority, Password, Username, IsAccountNonExpired, isAccountNotLocked,isEnables) object
	 * 
	 * So Delegating filter creates authentication object using the credential entered by user and calls the authenticate method of 
	 * Manager which inturn calls the appropriate providers. Provider the using userDetailsService gets the userDetails object
	 * and return the modified authentication object which is then placed inside a security context ThreadLocal object and is used
	 * during Authorization. After this a session filter takes this authenticated object and place it inside the session, so that we
	 * don't have to authenticate for any subsequent request. This is also responsible for taking the context from session and set it
	 * back in the threadlocal object. 
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").and().
		withUser("user").password(passwordEncoder().encode("user")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/secure").hasRole("ADMIN").
		antMatchers("/").permitAll().
		and().formLogin();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}	

}
