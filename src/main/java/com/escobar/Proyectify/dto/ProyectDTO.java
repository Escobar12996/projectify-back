package com.escobar.Proyectify.dto;

import com.escobar.Proyectify.model.Proyect;

public class ProyectDTO {
    private Long id;
    private String name;

    public ProyectDTO(Proyect proyect) {
        this.id = proyect.getId();
        this.name = proyect.getName();
        // Mapea otros campos
    }

    // Getter y Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
