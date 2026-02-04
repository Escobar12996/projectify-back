package com.escobar.Proyectify.component;

import org.springframework.stereotype.Component;

@Component("roles")
public class Roles {

    public final String creatorRole = "CREATOR";
	public final String adminRole = "ADMIN";
	public final String userRole = "USER";

    public String creator() { return creatorRole; }
    public String admin() { return adminRole; }
    public String user() { return userRole; }
}
