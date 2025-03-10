package com.escobar.Proyectify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ProyectifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectifyApplication.class, args);
	}

}
