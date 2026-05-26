package com.escobar.Proyectify.dto;

import com.escobar.Proyectify.model.Proyect;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProyectRequest {

    @NotBlank(message = "{proyect.name.required}")
    @Size(max = Proyect.MAXPROYECTNAME, message = "{proyect.name.size}")
    private String nameProyect;

    public String getNameProyect() {
        return nameProyect;
    }

    public void setNameProyect(String nameProyect) {
        this.nameProyect = nameProyect;
    }
}
