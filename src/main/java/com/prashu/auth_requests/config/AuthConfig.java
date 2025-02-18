package com.prashu.auth_requests.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {


}


//@EnableWebSecurity
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//  http.authorizeHttpRequests((authorize) -> authorize
//      .requestMatchers(new AntPathRequestMatcher("/auth")).permitAll()
//      .anyRequest().authenticated()
//    )
//    .csrf(AbstractHttpConfigurer::disable)
//    .formLogin(Customizer.withDefaults());	// Traditional login form setup
//  return http.build();
//}