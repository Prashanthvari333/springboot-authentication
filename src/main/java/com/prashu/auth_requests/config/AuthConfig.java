package com.prashu.auth_requests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
	  http.authorizeHttpRequests((authorize) -> authorize
	      .requestMatchers(new AntPathRequestMatcher("/api")).permitAll()
	      .anyRequest().authenticated()
	    )
	    .csrf(AbstractHttpConfigurer::disable) // to disable csrf so that for post requests we dont need to send csrf token
	    .formLogin(Customizer.withDefaults()) // Traditional login form setup : in web form login is used to validate the endpoint
	    .httpBasic(Customizer.withDefaults()) // in postman  basic auth is used to validate the endpoint
	    ;	
	  return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("xyz").password("123").roles("USER").build();
		return new InMemoryUserDetailsManager(user1);
	}


}



