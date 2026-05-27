package com.escobar.Proyectify.security;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;
import com.escobar.Proyectify.service.impl.UserSessionServiceImp;
import com.escobar.Proyectify.service.impl.UserServiceImp;
import com.escobar.Proyectify.security.dto.LoginRequest;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final BCryptPasswordEncoder encoder;

    public UserServiceAuth(@Value("${security.bcrypt.strength}") int bcryptStrength) {
        this.encoder = new BCryptPasswordEncoder(bcryptStrength);
    }

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(LoginRequest user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        UserPrincipal userPrinc = (UserPrincipal) authentication.getPrincipal();
        String newToken = jwtService.generateToken(userPrinc);
        registerSession(userPrinc.getUser(), newToken);
        return newToken;
    }

    public String renewToken(String refreshToken, UserPrincipal userPrincipal) {
        refreshToken = refreshToken.substring(7);
        String username = jwtService.extractUserName(refreshToken);

        User existingUser = repo.findByUsername(username);
        if (existingUser == null) {
            throw new UsernameNotFoundException("error.account.notFound");
        }

        String newToken = jwtService.generateToken(userPrincipal);
        renewSession(userPrincipal.getUser(), refreshToken, newToken);
        return newToken;
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

    public void logOutSession(User user, String token) {
        token = token.substring(7);
        UserSession oldSession = userSessionService.findByUserAndToken(user, token);
        if (oldSession != null) {
            userSessionService.delete(oldSession);
        }
    }
}
