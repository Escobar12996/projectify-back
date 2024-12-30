package com.escobar.Proyectify.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stages")
public class Stage {
    

    public static final int MAXSTAGENAME = 20;
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = MAXSTAGENAME, name = "stage_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "stage_proyect_id", nullable = false)
    private Proyect proyect;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public static int getMaxstagename() {
        return MAXSTAGENAME;
    }

    public String getName() {
        return name;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProyect(Proyect proyect) {
        this.proyect = proyect;
    }

    public Proyect getProyect() {
        return proyect;
    }
}
