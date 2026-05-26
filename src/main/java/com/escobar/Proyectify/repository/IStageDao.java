package com.escobar.Proyectify.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.escobar.Proyectify.model.Stage;

/**
 *
 * @author escobar
 */
public interface IStageDao extends CrudRepository<Stage, Long> {

    public Optional<Stage> findById(Long id);

}
