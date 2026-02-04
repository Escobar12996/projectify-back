package com.escobar.Proyectify.component;

import org.springframework.stereotype.Component;

@Component("swaggerProps")
public class SwaggerProps {

    public final String apiTitle = "My API";
    public final String apiVersion = "1.0";
    public final String apiDescription = "API for my application";
    public final String apiSecuritySchemes = "BearerAuth";
    public final String bearerFormat = "JWT";

    public String apiTitle() { return apiTitle; }
    public String apiVersion() { return apiVersion; }
    public String apiDescription() { return apiDescription; }
    public String apiSecuritySchemes() { return apiSecuritySchemes; }
    public String bearerFormat() { return bearerFormat; }
}
