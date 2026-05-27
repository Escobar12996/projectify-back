package com.escobar.Proyectify.repository;

import com.escobar.Proyectify.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}
