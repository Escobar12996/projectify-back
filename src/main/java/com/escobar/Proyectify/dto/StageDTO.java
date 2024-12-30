package com.escobar.Proyectify.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.escobar.Proyectify.model.Stage;

public class StageDTO {
    private Long id;
    private String name;
    private List<TaskDTO> tasks;

    public StageDTO(Stage stage) {
        this.id = stage.getId();
        this.name = stage.getName();
        this.tasks = stage.getTasks().stream()
                            .map(TaskDTO::new)
                            .collect(Collectors.toList());
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

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }
}
