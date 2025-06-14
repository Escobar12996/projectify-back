package com.escobar.Proyectify.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title(AppConfig.apiTitle)
						.version(AppConfig.apiVersion)
						.description(AppConfig.apiDescription))
				.addSecurityItem(new SecurityRequirement().addList(AppConfig.apiSecuritySchemes))
				.components(new io.swagger.v3.oas.models.Components()
						.addSecuritySchemes(AppConfig.apiSecuritySchemes, new SecurityScheme()
								.name(AppConfig.authHeader)
								.type(SecurityScheme.Type.APIKEY)
								.in(SecurityScheme.In.HEADER)
								.bearerFormat(AppConfig.bearerFormat)));
	}
}
