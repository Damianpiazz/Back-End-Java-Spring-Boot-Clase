package com.techlab.c14.springboot_demo_c14.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TechLab API - Gestión de Productos")
                        .version("1.0.0")
                        .description("API REST para gestionar productos del catálogo TechLab. Soporta operaciones CRUD completas.")
                        .contact(new Contact()
                                .name("Equipo TechLab")
                                .email("soporte@techlab.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}