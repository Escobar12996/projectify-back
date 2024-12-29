package com.escobar.Proyectify.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.escobar.Proyectify.dto.ProyectDTO;
import com.escobar.Proyectify.dto.ProyectRequest;
import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.repository.service.implement.ProyectServiceImp;
import com.escobar.Proyectify.service.security.model.UserPrincipal;
import jakarta.transaction.Transactional;

@RestController
public class ProyectController {

    @Autowired
    private ProyectServiceImp proyectServiceImp;

    @PostMapping("/register")
    public Proyect register(@RequestBody ProyectRequest proyectRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserPrincipal) principal).getUser();

        Proyect proyect = new Proyect();
        proyect.setName(proyectRequest.getNameProyect());
        proyect.setOwnUser(user);
        return proyectServiceImp.save(proyect);
    }

    @GetMapping("/getProyects")
    @Transactional
    public List<ProyectDTO> getProyects() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserPrincipal) principal).getUser();

        List<Proyect> proyects = proyectServiceImp.findByownUser(user);
        return proyects.stream()
                .map(ProyectDTO::new)
                .toList();
    }

}
