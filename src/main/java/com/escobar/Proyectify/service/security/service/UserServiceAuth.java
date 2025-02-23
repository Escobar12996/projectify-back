package com.escobar.Proyectify.service.security.service;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.service.implement.UserServiceImp;
import com.escobar.Proyectify.service.security.dto.LoginRequest;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAuth {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserServiceImp repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(LoginRequest user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            // Extraer authorities
            List<String> authorities = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Generar token con authorities
            return jwtService.generateToken(user.getUsername(), authorities);
        } else {
            return "Internal Error";
        }
    }

    public String renewToken(String refreshToken) {
        try {
    
            // Obtener el usuario del refresh token
            refreshToken = refreshToken.substring(7);
            String username = jwtService.extractUserName(refreshToken);
    
            // Verificar que el usuario existe
            User user = repo.findByUsername(username);
            if (user == null) {
                throw new RuntimeException("User not found");
            }
    
            List<String> authorities = user.getRoles()
                    .stream()
                    .map(role -> role.getName())
                    .collect(Collectors.toList());
    
            // Generar un nuevo access token
            return jwtService.generateToken(username, authorities);
    
        } catch (Exception e) {
            throw new RuntimeException("Invalid or expired refresh token", e);
        }
    }
}
