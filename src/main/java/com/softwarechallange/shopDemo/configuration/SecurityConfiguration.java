package com.softwarechallange.shopDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Config für die Application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
     * Passt die Security Filter Chain an.
     * - CSRF wird deaktiviert.
     * - CORS wird deaktiviert.
     * - Alle REST Anfragen werden zugelassen.
     * 
     * @param http HttpSecurity.
     * @return Angepasste Filter Chain.
     * @throws Exception Im Fehlerfall. 
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                    authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                            .anyRequest().permitAll()
            )
            .httpBasic(AbstractHttpConfigurer::disable)
            .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
