package com.escobar.Proyectify.service.security.service;

import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.service.implement.UserServiceImp;
import com.escobar.Proyectify.service.security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImp userRepo;


    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("error.account.notFound");
        }
        
        return new UserPrincipal(user);
    }
}
