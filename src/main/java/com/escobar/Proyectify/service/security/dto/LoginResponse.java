package com.escobar.Proyectify.service.security.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginResponse {

	@NotBlank(message = "Token required")
	private String token;

	public LoginResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
