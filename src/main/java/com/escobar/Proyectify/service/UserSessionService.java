package com.escobar.Proyectify.service;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;

public interface UserSessionService {

    public UserSession findByUserAndToken(User user, String token);

    public UserSession save(UserSession user);

    public void delete(UserSession user);
}
