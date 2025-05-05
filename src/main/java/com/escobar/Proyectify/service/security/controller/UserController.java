package com.escobar.Proyectify.service.security.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.escobar.Proyectify.dto.ErrorResponse;
import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.service.security.dto.LoginRequest;
import com.escobar.Proyectify.service.security.dto.LoginResponse;
import com.escobar.Proyectify.service.security.model.UserPrincipal;
import com.escobar.Proyectify.service.security.service.UserServiceAuth;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
public class UserController {

    private final UserServiceAuth service;

    public UserController(UserServiceAuth service) {
        this.service = service;
    }

    @Operation(summary = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: wrong credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden: access denied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody LoginRequest user) {
        return new LoginResponse(service.verify(user));
    }

    @Operation(summary = "Renew Token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: wrong credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden: access denied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/renew-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse renewToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserPrincipal user = ((UserPrincipal) principal);

        return new LoginResponse(service.renewToken(authorizationHeader, user));
    }
}
