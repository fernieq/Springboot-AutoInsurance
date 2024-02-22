
package com.synergisticit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired UserDetailsService userDetailsService;
	@Autowired AuthenticationSuccessHandlerImpl sucessHandler;
	@Autowired AccessDeniedHandlerImpl accessDeniedHandler;
	
	@Bean 
	public SecurityFilterChain apiFilterChain2(HttpSecurity http) throws Exception {
		http
		.apply(MyCustomDsl.customDsl())
		.flag(true).and()
		.authorizeRequests()
			.requestMatchers("/", "/home").permitAll().and()
		      .exceptionHandling().accessDeniedPage("/accessDenied").and()
		.authorizeRequests()
			.requestMatchers("/autoInsurancePlan", "/standardPlan", "/premiumPlan","/supremePlan","/vehicleRegistration", "/payment").hasAnyAuthority("USER").and()
	.formLogin()
		.loginPage("/signin")
		.defaultSuccessUrl("/home").permitAll().and()
	.logout()
	.logoutSuccessUrl("/signin")
    .invalidateHttpSession(true)
    .deleteCookies("JSESSIONID")
    .permitAll();
	
	http.userDetailsService(userDetailsService);
	  
	return http.build();
	}
	

}
