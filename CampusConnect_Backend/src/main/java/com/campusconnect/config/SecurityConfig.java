package com.campusconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.campusconnect.security.JwtAuthenticationFilter;
import com.campusconnect.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomUserDetailsService customUserDetailsService) {

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth

                // Public APIs
                .requestMatchers(
                        "/api/users/register",
                        "/api/users/login"
                ).permitAll()

                // Admin APIs
                .requestMatchers("/api/admin/**")
                .hasRole("ADMIN")

                // Student APIs
                .requestMatchers("/api/students/**")
                .hasAnyRole("STUDENT", "ADMIN")

                // Alumni APIs
                .requestMatchers("/api/alumni/**")
                .hasAnyRole("ALUMNI", "ADMIN")

                // Guidance APIs
                .requestMatchers("/api/guidance/**")
                .hasAnyRole("ALUMNI", "ADMIN")

                // Chat APIs
                .requestMatchers("/api/chat/**")
                .hasAnyRole("STUDENT", "ALUMNI", "ADMIN")

                // All other APIs
                .anyRequest()
                .authenticated()
            )

            .authenticationProvider(authenticationProvider())

            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}