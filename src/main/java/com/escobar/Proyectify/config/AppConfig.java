package com.escobar.Proyectify.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter // Lombok generará los getters automáticamente
@Setter // Lombok generará los setters automáticamente
@Component
@ConfigurationProperties(prefix = "configuracion")
public class AppConfig {

    private int campoNombreMinimo = 3;
    private int campoNombreMaximo = 50;
    private int jwtExpiracion = 3600;

}
