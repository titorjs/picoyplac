package com.titorjs.pyp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.time.Duration;
import java.util.List;

@Configuration
public class SecurityConfig {

    // -- Cargar el origen permitido desde application-*.yml
    @Value("${app.cors.allowed-origin}")
    private String allowedOrigin;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration cfg = new CorsConfiguration();
                    cfg.setAllowedOrigins(List.of(allowedOrigin));
                    cfg.setAllowedMethods(List.of("GET"));
                    cfg.setAllowedHeaders(List.of("*"));
                    cfg.setMaxAge(Duration.ofHours(3));
                    return cfg;
                }));

        return http.build();
    }
}

