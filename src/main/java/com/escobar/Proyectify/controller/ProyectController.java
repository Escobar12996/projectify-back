package com.escobar.Proyectify.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escobar.Proyectify.component.UrlsProps;
import com.escobar.Proyectify.dto.ProyectDTO;
import com.escobar.Proyectify.dto.ProyectListDTO;
import com.escobar.Proyectify.dto.ProyectRequest;
import com.escobar.Proyectify.model.Proyect;
import com.escobar.Proyectify.model.User;
import com.escobar.Proyectify.model.repository.service.implement.ProyectServiceImp;
import com.escobar.Proyectify.service.security.model.UserPrincipal;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(UrlsProps.BASE_URL + UrlsProps.PROYECT_URL_BASE)
public class ProyectController {

    @Autowired
    private ProyectServiceImp proyectServiceImp;

    @PostMapping(value = UrlsProps.REGISTER, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole(@roles.creator())")
    public ProyectListDTO register(@RequestBody ProyectRequest proyectRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((UserPrincipal) authentication.getPrincipal()).getUser();

        Proyect proyect = new Proyect();
        proyect.setName(proyectRequest.getNameProyect());
        proyect.setOwnUser(user);
        return new ProyectListDTO(proyectServiceImp.save(proyect));
    }

    @GetMapping(value = UrlsProps.GET_USER_ALL_PROYECTS, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole(@roles.user())")
    @Transactional
    public List<ProyectListDTO> getProyects() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((UserPrincipal) authentication.getPrincipal()).getUser();
        return proyectServiceImp.findByownUser(user).stream()
                .map(ProyectListDTO::new)
                .toList();
    }

    @GetMapping(value = UrlsProps.GET_PROYECT + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole(@roles.user())")
    @Transactional
    public ProyectDTO getProyect(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((UserPrincipal) authentication.getPrincipal()).getUser();
        return new ProyectDTO(proyectServiceImp.findByIdAndownUser(id, user));
    }
}
