package com.escobar.Proyectify.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.escobar.Proyectify.model.Proyect;

/**
 *
 * @author escobar
 */
public interface IProyectDao extends CrudRepository<Proyect, Long> {

    public Optional<Proyect> findById(Long id);

}
