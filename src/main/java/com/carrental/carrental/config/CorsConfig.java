package com.carrental.carrental.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;


@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter (){
        CorsConfiguration config = new CorsConfiguration();

        // ==============================
        // ALLOWED ORIGINS (React apps)
        // ==============================
        // DEV (Vite, CRA, Next.js etc.)
        config.setAllowedOrigins(List.of(
                "http://localhost:3000",
                "http://localhost:5173"
        ));

        // ==============================
        // ALLOWED HTTP METHODS
        // ==============================
        config.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "PATCH",
                "DELETE",
                "OPTIONS"
        ));

        // ==============================
        // ALLOWED HEADERS
        // ==============================
        config.setAllowedHeaders(List.of(
                "Authorization",
                "Content-Type",
                "X-Requested-With",
                "Accept",
                "Origin"
        ));

        // ==============================
        // EXPOSED HEADERS
        // ==============================
        // Headers that frontend JS can read
        config.setExposedHeaders(List.of(
                "Authorization"
        ));

        // ==============================
        // ALLOW COOKIES / CREDENTIALS
        // ==============================
        config.setAllowCredentials(true);

        // ==============================
        // CACHE PREFLIGHT RESPONSE
        // ==============================
        config.setMaxAge(3600L); // 1 hour

        // ==============================
        // APPLY TO ALL ENDPOINTS
        // ==============================
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
