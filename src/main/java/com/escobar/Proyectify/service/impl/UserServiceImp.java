package com.escobar.Proyectify.service.impl;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.repository.IUserDao;
import com.escobar.Proyectify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

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
