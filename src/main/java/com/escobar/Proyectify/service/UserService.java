package com.escobar.Proyectify.service;

import com.escobar.Proyectify.model.User;

public interface UserService {

    public User findByUsername(String username);

    public User save(User user);

}
