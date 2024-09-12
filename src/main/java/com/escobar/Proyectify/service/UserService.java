/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.service;

import com.escobar.Proyectify.model.User;

/**
 *
 * @author escobar
 */
public interface UserService {

    public User findByUsername(String username);

    public User save(User user);

}
