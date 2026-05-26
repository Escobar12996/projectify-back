package com.escobar.Proyectify.config;

import com.escobar.Proyectify.component.SecurityProps;
import com.escobar.Proyectify.component.SwaggerProps;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final SecurityProps securityProps;
    private final SwaggerProps swaggerProps;

    public SwaggerConfig(SecurityProps securityProps, SwaggerProps swaggerProps) {
        this.securityProps = securityProps;
        this.swaggerProps = swaggerProps;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(swaggerProps.apiTitle())
                        .version(swaggerProps.apiVersion())
                        .description(swaggerProps.apiDescription())
                )
                .addSecurityItem(new SecurityRequirement().addList(securityProps.securitySchemeName()))
                .components(new Components()
                        .addSecuritySchemes(securityProps.securitySchemeName(),
                                new SecurityScheme()
                                        .name(securityProps.authHeader())
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(securityProps.schemeConfig())
                                        .bearerFormat(securityProps.bearerFormat())
                        )
                );
    }
}
