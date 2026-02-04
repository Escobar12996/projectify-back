package com.escobar.Proyectify.component;

import org.springframework.stereotype.Component;

@Component("urlsProps")
public class UrlsProps {

    // Base
    public final String baseUrlApi = "/api";
    public final String baseUrl = baseUrlApi + "/v1";

    // Auth
    public final String login = "/login";
    public final String renew = "/renew-token";
    public final String logout = "/logout";

    // Proyect
    public final String proyectUrlBase = "/proyect";
    public final String register = "/register";
    public final String getUserAllProyects = "/getProyects";
    public final String getProyect = "/getProyect";

    public String baseUrlApi() { return baseUrlApi; }
    public String baseUrl() { return baseUrl; }

    public String login() { return login; }
    public String renew() { return renew; }
    public String logout() { return logout; }

    public String proyectUrlBase() { return proyectUrlBase; }
    public String register() { return register; }
    public String getUserAllProyects() { return getUserAllProyects; }
    public String getProyect() { return getProyect; }
}
