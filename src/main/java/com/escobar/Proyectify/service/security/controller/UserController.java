package com.escobar.Proyectify.service.security.controller;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escobar.Proyectify.config.AppConfig;
import com.escobar.Proyectify.dto.ErrorResponse;
import com.escobar.Proyectify.dto.OkResponse;
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

@RequestMapping(AppConfig.baseUrlApi)
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
    @PostMapping(value = AppConfig.login, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody LoginRequest user) {
        return new LoginResponse(service.verify(user));
    }

    @Operation(summary = "Renew Token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: wrong credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden: access denied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = AppConfig.renew, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse renewToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserPrincipal user = ((UserPrincipal) principal);

        return new LoginResponse(service.renewToken(authorizationHeader, user));
    }

    @Operation(summary = "LogOut")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OkResponse.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = AppConfig.logout, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserPrincipal user = ((UserPrincipal) principal);
        service.logOutSession(user.getUser(), authorizationHeader);

        return ResponseEntity.ok(Map.of("message", this.getTranslatedMessage("user.logout")));
    }

    private String getTranslatedMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(AppConfig.bundleLocale, locale);
        return bundle.getString(key);
    }
}
