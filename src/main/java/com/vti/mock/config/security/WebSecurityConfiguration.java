package com.vti.mock.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.vti.mock.service.IAdminService;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IAdminService service;
	
	// Không cần mã hóa password
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}
	
	//	Phân quyền 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.authorizeRequests()
				.antMatchers("/api/v1/admin").hasAnyAuthority("Admin")
				.antMatchers(HttpMethod.DELETE, "/api/v1/users").hasAnyAuthority("Admin")
				.antMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
				.antMatchers(HttpMethod.POST, "/api/v1/users/fbId/favourite").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/v1/users/fbId/favourite").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/users").hasAnyAuthority("Admin")
				.antMatchers(HttpMethod.GET, "/api/v1/users/*").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/cities").permitAll()
				.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}
	
	  @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
}