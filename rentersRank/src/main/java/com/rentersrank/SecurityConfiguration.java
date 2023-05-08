package com.rentersrank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebMvcConfigurerAdapter {
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	  
//	@Autowired
//	  
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	      auth.inMemoryAuthentication()
//	        .withUser("admin").password(passwordEncoder.encode("infytel")).authorities("ROLE_ADMIN");
//	  }
//	
//	  
//	@Override 
//	  
//	protected void configure(HttpSecurity http) throws Exception {
//	      http.cors().and().authorizeRequests()//enabling CORS in security
//	        .antMatchers("/").permitAll()
//	        .anyRequest().authenticated()//only authentication and no authorization is required
//	        .and(). 
//	        httpBasic().and()
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and().csrf().disable();
//	        }
}