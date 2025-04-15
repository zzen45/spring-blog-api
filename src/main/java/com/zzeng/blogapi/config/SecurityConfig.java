package com.zzeng.blogapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for postman testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // API routes allowed
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
