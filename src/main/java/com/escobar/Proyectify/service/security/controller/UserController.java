package com.escobar.Proyectify.service.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.escobar.Proyectify.dto.ErrorResponse;
import com.escobar.Proyectify.service.security.dto.LoginRequest;
import com.escobar.Proyectify.service.security.dto.LoginResponse;
import com.escobar.Proyectify.service.security.service.UserServiceAuth;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class UserController {

    @Autowired
    private UserServiceAuth service;

    @Operation(summary = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized: wrong credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden: access denied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest user) {
        return new LoginResponse(service.verify(user));

    }

    /*
     * @PostMapping("/register")
     * public User register(@RequestBody User user) {
     * return service.register(user);
     * }
     */

    @PostMapping("/renew-token")
     public ResponseEntity<?> renewToken(HttpServletRequest request) {
    // Accede al encabezado Authorization
    String authorizationHeader = request.getHeader("Authorization");
        try {
            String newToken = service.renewToken(authorizationHeader);
            return ResponseEntity.ok(newToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }
    }

}
