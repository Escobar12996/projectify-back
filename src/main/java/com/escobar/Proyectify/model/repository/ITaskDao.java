package com.escobar.Proyectify.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.escobar.Proyectify.model.Task;

/**
 *
 * @author escobar
 */
public interface ITaskDao extends CrudRepository<Task, Long> {

    public Optional<Task> findById(Long id);

}
