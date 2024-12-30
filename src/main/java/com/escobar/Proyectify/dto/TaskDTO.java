package com.escobar.Proyectify.dto;

import com.escobar.Proyectify.model.Task;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;

    public TaskDTO(Task stage) {
        this.id = stage.getId();
        this.name = stage.getName();
        this.description = stage.getDescription();
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
