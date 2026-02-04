package com.escobar.Proyectify.config;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

	// swagger config
	public static final String apiTitle = "My API";
	public static final String apiVersion = "1.0";
	public static final String apiDescription = "API for my application";
	public static final String apiSecuritySchemes = "BearerAuth";
	public static final String bearerFormat = "JWT";

	// Messages Traduction
	public static final String bundleLocale = "messages";

	// Urls
	public static final String baseUrlApi = "/api";
	public static final String baseUrl = baseUrlApi + "/v1";

	public static final String login = "/login";
	public static final String renew = "/renew-token";
	public static final String logout = "/logout";

	public static final String proyectUrlBase = "/proyect";
	public static final String register = "/register";
	public static final String getUserAllProyects = "/getProyects";
	public static final String getProyect = "/getProyect";

}
