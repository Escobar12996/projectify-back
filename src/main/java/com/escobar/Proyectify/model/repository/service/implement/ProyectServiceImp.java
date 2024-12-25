package com.escobar.Proyectify.model.repository.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.repository.IProyectDao;
import com.escobar.Proyectify.model.repository.service.ProyectService;

/**
 *
 * @author escobar
 */
@Service
public class ProyectServiceImp implements ProyectService{

    @Autowired
    private IProyectDao userDao;

    @Override
    public Optional<Proyect> findById(Long id) {
        return this.userDao.findById(id);
    }

    @Override
    public Proyect save(Proyect proyect) {
        return this.userDao.save(proyect);
    }

}
