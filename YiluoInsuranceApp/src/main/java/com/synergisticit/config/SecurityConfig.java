
package com.synergisticit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired UserDetailsService userDetailsService;
	@Autowired AuthenticationSuccessHandlerImpl sucessHandler;
	@Autowired AccessDeniedHandlerImpl accessDeniedHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public SecurityFilterChain apiFilterChain2(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
//		.requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
//		.requestMatchers(AntPathRequestMatcher.antMatcher("/WEB-INF/views/**")).permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()// required to display the default form provided by Spring to login
//		.loginPage("/login")
//		.loginProcessingUrl("/login")
//		
//		//.defaultSuccessUrl("/employeeForm", false);
//		//.defaultSuccessUrl("/home", false);
//		.successHandler(sucessHandler)
//		.and()
//		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//		
//		http.userDetailsService(userDetailsService);
//		return http.build();
		http
		.apply(MyCustomDsl.customDsl())
		.flag(true).and()
		.authorizeRequests()
			.requestMatchers("/", "/home").permitAll().and()
		      .exceptionHandling().accessDeniedPage("/accessDeniedPage").and()
		.authorizeRequests()
			.requestMatchers("/bookHotel", "/userProfile","/welcome","/restrict").hasAnyAuthority("USER","ADMIN").and()
	.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/home").permitAll().and()
	.logout()
	.logoutSuccessUrl("/")
    .invalidateHttpSession(true)
    .deleteCookies("JSESSIONID")
    .permitAll();
	
	return http.build();
	}
	

}
