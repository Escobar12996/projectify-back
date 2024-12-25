/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.service.implement;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.repository.IUserDao;
import com.escobar.Proyectify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escobar
 */
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private IUserDao userDao;

	@Override
	public User findByUsername(String username) {
		return this.userDao.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return this.userDao.save(user);
	}
}