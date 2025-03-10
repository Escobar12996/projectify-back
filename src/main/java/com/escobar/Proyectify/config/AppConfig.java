package com.escobar.Proyectify.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration // Es mejor usar @Configuration en vez de @Component
@ConfigurationProperties(prefix = "configuration") // Asegura que Spring cargue las propiedades correctamente
public class AppConfig {

    private String secretKey;

}
