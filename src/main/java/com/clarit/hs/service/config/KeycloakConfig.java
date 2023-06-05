package com.clarit.hs.service.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class KeycloakConfig {

    public KeycloakSpringBootConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
