package com.soltel.islantilla.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI personalizarAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Endpoints Islantilla")
                .description("Documentación Endpoints Islantilla")
                .version("1.0")
                .contact(new Contact()
                    .name("Iván Rodríguez")
                    .url("http://www.soltel.es")
                    .email("ivan.rodriguez@soltel.es"))
                .license(new License()
                    .name("MIT")
                    .url("https://www.mit.edu"))
                .termsOfService("Swagger de Islantilla. Sin Garantia"))
            .components(new Components()
                    .addSecuritySchemes("basicAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("basic")))
            .servers(Arrays.asList(new Server()
                .url("http://localhost:8100").
                description("Entorno de pruebas")));
    }
}
