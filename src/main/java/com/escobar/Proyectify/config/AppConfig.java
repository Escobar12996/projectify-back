package com.escobar.Proyectify.config;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

	// Security
	public static final String authHeader = "Authorization";
	public static final String authHeaderStart = "Bearer ";
	public static final List<String> authorizeHttpRequests = new ArrayList<>(
			List.of("/api/login", "error", "/v2/api-docs", "/swagger-resources/**", "/configuration/ui",
					"/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**"));
	public static final List<String> authorizeOrigins = new ArrayList<>(List.of("http://localhost:4200"));
	public static final List<String> allowedMethods = new ArrayList<>(
			List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	public static final List<String> allowedHeaders = new ArrayList<>(List.of(authHeader, "Content-Type"));
	public static final List<String> axposedHeaders = new ArrayList<>(List.of(authHeader));

	// swagger config
	public static final String apiTitle = "My API";
	public static final String apiVersion = "1.0";
	public static final String apiDescription = "API for my application";
	public static final String apiSecuritySchemes = "BearerAuth";
	public static final String bearerFormat = "JWT";

	// Urls
	public static final String baseUrl = "/api/v1";

	public static final String proyectUrlBase = "/proyect";

}
