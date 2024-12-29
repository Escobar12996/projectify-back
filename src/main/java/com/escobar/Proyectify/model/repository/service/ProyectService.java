/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.model.repository.service;

import java.util.Optional;

import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;

/**
 *
 * @author escobar
 */
public interface ProyectService {

    public Optional<Proyect> findByIdAndownUser(Long id, User ownUser);

    public Proyect save(Proyect proyect);

}
