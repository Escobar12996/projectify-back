package com.escobar.Proyectify.component;

import org.springframework.stereotype.Component;

@Component("urlsProps")
public class UrlsProps {

    // Base
    public static final String BASE_URL_API = "/api";
    public static final String BASE_URL     = BASE_URL_API + "/v1";

    // Auth
    public static final String LOGIN  = "/login";
    public static final String RENEW  = "/renew-token";
    public static final String LOGOUT = "/logout";

    // Proyect
    public static final String PROYECT_URL_BASE      = "/proyect";
    public static final String REGISTER              = "/register";
    public static final String GET_USER_ALL_PROYECTS = "/getProyects";
    public static final String GET_PROYECT           = "/getProyect";

    // Métodos de instancia para uso desde SpEL en SecurityConfig (@urlsProps)
    public String baseUrlApi()          { return BASE_URL_API; }
    public String baseUrl()             { return BASE_URL; }
    public String login()               { return LOGIN; }
    public String renew()               { return RENEW; }
    public String logout()              { return LOGOUT; }
    public String proyectUrlBase()      { return PROYECT_URL_BASE; }
    public String register()            { return REGISTER; }
    public String getUserAllProyects()  { return GET_USER_ALL_PROYECTS; }
    public String getProyect()          { return GET_PROYECT; }
}
