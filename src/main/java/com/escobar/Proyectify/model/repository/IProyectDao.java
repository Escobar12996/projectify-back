package com.escobar.Proyectify.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;

/**
 *
 * @author escobar
 */
public interface IProyectDao extends CrudRepository<Proyect, Long> {

    @Query("SELECT p FROM Proyect p WHERE p.id = :id AND p.ownUser = :ownUser")
    Proyect findByIdAndownUser(Long id, User ownUser);

    @Query("SELECT p FROM Proyect p WHERE p.ownUser = :ownUser")
    List<Proyect> findByownUser(User ownUser);

}
