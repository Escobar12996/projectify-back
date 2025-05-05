package com.escobar.Proyectify.model.repository.service.implement;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.UserSession;
import com.escobar.Proyectify.model.repository.IUserSession;
import com.escobar.Proyectify.model.repository.service.UserSessionService;

/**
 *
 * @author escobar
 */
@Service
public class UserSessionServiceImp implements UserSessionService {

    @Autowired
    private IUserSession userSesionDao;

    @Override
    public UserSession findByUserAndToken(User user, String token) {
        return this.userSesionDao.findByUserAndToken(user, token);
    }

    @Override
    public UserSession save(UserSession userSession) {
        return this.userSesionDao.save(userSession);
    }

    @Override
    public void delete(UserSession userSession) {
        this.userSesionDao.delete(userSession);
    }

}
