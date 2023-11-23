package com.pizzeria.springdatajpa.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        corsConfiguration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500/"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","PATCH"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

        source.registerCorsConfiguration("/**",corsConfiguration);
        return  source;
    }
}
