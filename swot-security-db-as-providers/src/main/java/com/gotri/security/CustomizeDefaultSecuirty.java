package com.gotri.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class CustomizeDefaultSecuirty extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

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
		auth.jdbcAuthentication().dataSource(dataSource)
								 .usersByUsernameQuery("select username,password,enabled from users where username = ?")
								 .groupAuthoritiesByUsername("select username,authority from authorities where username = ?");
		
		/**
		 * Create default schema and populate it with data. We can place the schema.sql with default schema and data.sql with
		 * data and simply start the application
		 * 
		 * If we want to override the default schema and we can create it as per our needs and call the above method by passing
		 *  query inside
		 *  
		 * To use your own database, pass the below details in application.properties
		 * Oracle settings
		 * spring.datasource.url=jdbc:oracle:thin:@192.168.11.41:1521:segdb
		 * spring.datasource.username=gtpl_elitesmp
		 * pring.datasource.password=gtpl_elitesmp
		 * spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
		 * spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect
		 * spring.jpa.hibernate.ddl-auto=none
		 * spring.jpa.show-sql=true
		 * 
		 */
								 
		
							/*With H2 default schema and few users
							 * 
							 * .withDefaultSchema()
								 .withUser(
										 User.withUsername("user")
										 .password(passwordEncoder().encode("user"))
										 .roles("USER")										 
										 )
								 .withUser(
										 User.withUsername("admin")
										 .password(passwordEncoder().encode("admin"))
										 .roles("ADMIN")										 
										 );*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/secure/admin").hasRole("ADMIN")
								.antMatchers("/secure/user").hasAnyRole("ADMIN","USER")
								.antMatchers("/").permitAll()
								.and().formLogin();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}	

}
