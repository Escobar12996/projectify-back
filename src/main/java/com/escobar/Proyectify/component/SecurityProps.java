package com.escobar.Proyectify.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("securityProps")
public class SecurityProps {

    public final String authHeader         = "Authorization";
    public final String authHeaderStart    = "Bearer ";
    public final String schemeConfig       = "bearer";
    public final String bearerFormat       = "JWT";
    public final String securitySchemeName = "bearerAuth";

    public final List<String> authorizeHttpRequests = List.of(
            "/api/login",
            "error",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    );

    // CORS origin desde properties — cambia entre dev y producción
    @Value("${cors.allowed.origin}")
    private String allowedOrigin;

    public final List<String> allowedMethods = List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
    );

    public final List<String> allowedHeaders = List.of(
            authHeader, "Content-Type"
    );

    public final List<String> exposedHeaders = List.of(authHeader);

    public String authHeader()                  { return authHeader; }
    public String authHeaderStart()             { return authHeaderStart; }
    public List<String> authorizeHttpRequests() { return authorizeHttpRequests; }
    public List<String> authorizeOrigins()      { return List.of(allowedOrigin); }
    public List<String> allowedMethods()        { return allowedMethods; }
    public List<String> allowedHeaders()        { return allowedHeaders; }
    public List<String> exposedHeaders()        { return exposedHeaders; }
    public String schemeConfig()                { return schemeConfig; }
    public String bearerFormat()                { return bearerFormat; }
    public String securitySchemeName()          { return securitySchemeName; }
}
