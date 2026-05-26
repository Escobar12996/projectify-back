package com.escobar.Proyectify.config;

public class AppConfig {

    // Usado directamente por JwtFilter, CustomExceptionHandler y UserController
    // para resolver mensajes i18n vía ResourceBundle
    public static final String bundleLocale = "messages";
}
