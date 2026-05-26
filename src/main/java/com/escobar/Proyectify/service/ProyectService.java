/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.service;

import java.util.List;

import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;

/**
 *
 * @author escobar
 */
public interface ProyectService {

    public Proyect findByIdAndownUser(Long id, User ownUser);

    public List<Proyect> findByownUser(User ownUser);

    public Proyect save(Proyect proyect);

}
