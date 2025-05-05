package com.escobar.Proyectify.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;

/**
 *
 * @author escobar
 */
public interface IUserSession extends CrudRepository<UserSession, String> {

    @Query("SELECT p FROM UserSession p WHERE p.token = :token AND p.user = :user")
    UserSession findByUserAndToken(User user, String token);


}
