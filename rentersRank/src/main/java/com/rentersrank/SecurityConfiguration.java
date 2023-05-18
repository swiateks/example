package com.rentersrank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebMvcConfigurerAdapter {

	  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("Renter@rank.com").password("{noop}rent123").roles("RENTER").and().withUser("Lord@rank.com")
				.password("{noop}Lord123").roles("LANDLORD");
	}
	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/**").permitAll()
//				.antMatchers("/login*").permitAll().antMatchers("/**")
//				.hasAnyRole("RENTER", "LANDLORD").anyRequest().authenticated()
//				.and().formLogin().loginPage("/login")
//				.usernameParameter("username").passwordParameter("password")
//				.loginProcessingUrl("/doLogin")
//				.defaultSuccessUrl("/index", true).failureUrl("/accessDenied")
//				.permitAll().and().exceptionHandling()
//				.accessDeniedPage("/accessDenied");
//
//	}


	 @Configuration
//	 @Order(1)                                                        
	  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
	      protected void configure(HttpSecurity http) throws Exception {
	          http
//	              .antMatcher("/renter/**")                               
//	              		.authorizeRequests()
//	              		.anyRequest().hasRole("RENTER")
//	              		.and()
                  .antMatcher("/landlord/**")                               
	              		.authorizeRequests()
	              		.anyRequest().hasRole("LANDLORD")
	              		.and()
	              .formLogin()
	      	          .loginPage("/login*")
	      	          .permitAll()
	          		  .defaultSuccessUrl("/welcomeLandlord");
//	      	          .and()
//	      	      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
	      }
	  }    	  
	 
	 
	protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
		      .antMatchers("/**", "/login*").permitAll()   
	          .and()
          .formLogin()
	          .loginPage("/login*")
				.usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/browse") ///doLogin 	?
				.defaultSuccessUrl("/index", true).failureUrl("/accessDenied")
				.permitAll().and().exceptionHandling()
				.accessDeniedPage("/accessDenied");
//          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
  }
	
}