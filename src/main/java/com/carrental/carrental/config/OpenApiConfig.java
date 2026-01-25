package com.carrental.carrental.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI carRentalOpenAPI() {
        return new OpenAPI()
                // ==============================
                // API INFO (shown in Swagger UI)
                // ==============================
                .info(new Info()
                        .title("Car Rental Service API")
                        .description("REST API documentation for Car Rental Management System")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Car Rental Tech Team")
                                .email("support@carrental.com")
                                .url("https://carrental.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                // ==============================
                // GLOBAL SECURITY (JWT)
                // ==============================
                .addSecurityItem(new SecurityRequirement()
                        .addList(SECURITY_SCHEME_NAME))

                // ==============================
                // COMPONENTS (SECURITY SCHEME)
                // ==============================
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Enter JWT token like: Bearer eyJhbGciOi...")));
    }
}
