package com.soltel.islantilla.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Digo cuales van a ser los endpoint mapeados
        registry.addMapping("/clientes/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
        
        registry.addMapping("/reservas/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT")
            .allowedHeaders("*")
            .allowCredentials(true);

        // Otra opción sería derivar los endpoints de /api
    }
}
