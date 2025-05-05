/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.model.repository.service;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;

/**
 *
 * @author escobar
 */
public interface UserSessionService {

    public UserSession findByUserAndToken(User user, String token);

    public UserSession save(UserSession user);

    public void delete(UserSession user);
}
