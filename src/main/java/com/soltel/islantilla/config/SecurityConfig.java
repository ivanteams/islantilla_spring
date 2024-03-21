package com.soltel.islantilla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Recurso: https://spring.io/guides/gs/securing-web
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filtro (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.
            requestMatchers("/inicio")
            .hasRole("ADMIN")
            .anyRequest().authenticated())
            .formLogin(form -> form
            .defaultSuccessUrl("/inicio",true));
        return http.build();
    }

    @Bean
    public PasswordEncoder codificador() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService credenciales (PasswordEncoder codificador) {
        UserDetails usuarioAdmin = User.builder()
            .username("soltel")
            .password(codificador.encode("admin"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(usuarioAdmin);
    }
}
