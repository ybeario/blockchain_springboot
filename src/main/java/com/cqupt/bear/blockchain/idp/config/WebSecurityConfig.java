package com.cqupt.bear.blockchain.idp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月27日 下午3:55:21 类说明
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").defaultSuccessUrl("/success").failureUrl("/error")
				.loginProcessingUrl("/authentication/form").permitAll().and().authorizeRequests()
				.antMatchers("/login", "/assets/**", "/css/**", "/js/**","/index","/register").permitAll().anyRequest().authenticated().and()
				.logout().permitAll().and().csrf().disable().headers().frameOptions().disable();
		// http.formLogin().and().authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	}
}
