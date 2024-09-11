/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.repository;

import com.escobar.Proyectify.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author escobar
 */
public interface IUserDao extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}
