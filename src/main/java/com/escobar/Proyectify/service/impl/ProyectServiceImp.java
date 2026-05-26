package com.escobar.Proyectify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.repository.IProyectDao;
import com.escobar.Proyectify.service.ProyectService;

/**
 *
 * @author escobar
 */
@Service
public class ProyectServiceImp implements ProyectService{

    @Autowired
    private IProyectDao userDao;

    @Override
    public Proyect findByIdAndownUser(Long id, User ownUser) {
        return this.userDao.findByIdAndownUser(id, ownUser);
    }

    @Override
    public Proyect save(Proyect proyect) {
        return this.userDao.save(proyect);
    }

    @Override
    public List<Proyect> findByownUser(User ownUser) {
        return this.userDao.findByownUser(ownUser);
    }

}
