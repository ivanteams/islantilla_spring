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
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    // vamos a levantar la mano para el acceso
    // Evitamos problemas con swagger y el front (Angular)
    @Bean
    public SecurityFilterChain filtradoSeguridad (HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(request -> new CorsConfiguration()
                .applyPermitDefaultValues()))

            // CSRF controla las llamadas del Front
            .csrf(csrf -> csrf.disable())

            // Definimos los prefijos de los endpoints autorizados
            .authorizeHttpRequests(auth -> auth.
                requestMatchers("/clientes/**", "/reservas/**").permitAll()
                .anyRequest().authenticated())

            // Tras logarse con el formulario, saltar a un endpoint
            .formLogin(form -> form.defaultSuccessUrl("/menu",true));
        return http.build();
    }

    // Elegimos el encriptado de la contraseña
    @Bean
    public PasswordEncoder encriptado() {
        return new BCryptPasswordEncoder();
    }

    // Para definir credenciales de acceso
    @Bean
    public UserDetailsService credenciales (PasswordEncoder encriptado) {
        UserDetails usuarioPrincipal = User.builder()
            .username("soltel")
            .password(encriptado.encode("admin"))
            .roles("ADMIN")
            .build();
            
        return new InMemoryUserDetailsManager(usuarioPrincipal);
    }
}
