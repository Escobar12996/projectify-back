package com.escobar.Proyectify.service.security.service;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;
import com.escobar.Proyectify.model.repository.service.UserSessionService;
import com.escobar.Proyectify.model.repository.service.implement.UserSessionServiceImp;
import com.escobar.Proyectify.service.implement.UserServiceImp;
import com.escobar.Proyectify.service.security.dto.LoginRequest;
import com.escobar.Proyectify.service.security.model.UserPrincipal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UserSessionServiceImp userSessionService;

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
            UserPrincipal userPrinc = (UserPrincipal) authentication.getPrincipal();
            String newToken = jwtService.generateToken(userPrinc);
            this.registerSession(userPrinc.getUser(), newToken);
            return newToken;
        } else {
            return "error.internal";
        }
    }

    public String renewToken(String refreshToken, UserPrincipal userPrincipal) {
        try {

            // Obtener el usuario del refresh token
            refreshToken = refreshToken.substring(7);
            String username = jwtService.extractUserName(refreshToken);

            // Verificar que el usuario existe
            User userEsist = repo.findByUsername(username);
            if (userEsist == null) {
                throw new RuntimeException("error.accout.notFound");
            }

            // Generar un nuevo access token
            String newToken = jwtService.generateToken(userPrincipal);
            this.renewSession(userPrincipal.getUser(), refreshToken, newToken);

            return newToken;

        } catch (Exception e) {
            throw new RuntimeException("error.token.expired");
        }
    }

    public void renewSession(User user, String oldToken, String newToken) {
        UserSession oldSession = userSessionService.findByUserAndToken(user, oldToken);
        if (oldSession != null) {
            userSessionService.delete(oldSession);
        }
    
        UserSession newSession = new UserSession();
        newSession.setUser(user);
        newSession.setToken(newToken);
        newSession.setValid(true);
        newSession.setCreatedAt(LocalDateTime.now());
        userSessionService.save(newSession);
    }

    public void registerSession(User user, String token) {    
        UserSession newSession = new UserSession();
        newSession.setUser(user);
        newSession.setToken(token);
        newSession.setValid(true);
        newSession.setCreatedAt(LocalDateTime.now());
        userSessionService.save(newSession);
    }
}
