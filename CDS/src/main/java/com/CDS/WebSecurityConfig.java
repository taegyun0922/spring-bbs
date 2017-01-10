package com.CDS;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/game_list")
				.hasAnyRole("USER")
				.anyRequest()
				.authenticated()
			.antMatchers("/resources/**")
				.anonymous()
				.anyRequest()
				.permitAll()
		.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("user_id")
				.passwordParameter("user_pwd")
				.permitAll()
		.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll()
		.and()
			.csrf().disable();
			
			
	}
	
	

}
