package com.campusconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                // Allow registration and login
                .requestMatchers(
                    "/api/users/register",
                    "/api/users/login"
                ).permitAll()


                // Role based access
                .requestMatchers("/api/admin/**")
                .hasRole("ADMIN")


                .requestMatchers("/api/students/**")
                .hasAnyRole("STUDENT","ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/students/profile").hasRole("STUDENT")
//               
                
             // Only Alumni can create their profile
                .requestMatchers(HttpMethod.POST, "/api/alumni")
                .hasRole("ALUMNI")

                // Only Alumni can update their own profile
                .requestMatchers(HttpMethod.PUT, "/api/alumni/profile")
                .hasAnyRole("ALUMNI","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/alumni/profile").hasRole("ALUMNI")


                // Everyone can view/search alumni
                .requestMatchers(HttpMethod.GET, "/api/alumni/**")
                .hasAnyRole("STUDENT", "ALUMNI", "ADMIN")
                

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