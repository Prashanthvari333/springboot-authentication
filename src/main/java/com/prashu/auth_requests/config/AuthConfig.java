package com.prashu.auth_requests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class AuthConfig {
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	
//	  http.authorizeHttpRequests((authorize) -> authorize
//	      .requestMatchers(new AntPathRequestMatcher("/auth")).permitAll()
//	      .anyRequest().authenticated()
//	    )
//	    .csrf(AbstractHttpConfigurer::disable)
//	    .formLogin(Customizer.withDefaults());	// Traditional login form setup
//	  return http.build();
//	}


}



