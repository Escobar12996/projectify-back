package com.escobar.Proyectify.service;

import java.util.List;

import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;

public interface ProyectService {

    public Proyect findByIdAndownUser(Long id, User ownUser);

    public List<Proyect> findByownUser(User ownUser);

    public Proyect save(Proyect proyect);

}
