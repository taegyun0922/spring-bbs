package com.CDS;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource; 
	
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
	
	@Autowired
	private void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT user_id, user_pwd, enabled FROM user_basic_tbl WHERE user_id=?")
				.authoritiesByUsernameQuery("SELECT user_id, role FROM user_role WHERE user_id=?");
	}
	
}
