package com.escobar.Proyectify.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author escobar
 */
@Entity
@Table(name = "proyects")
public class Proyect implements Serializable {

    public static final int MAXPROYECTNAME = 50;
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, length = MAXPROYECTNAME, name="proyect_name", nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyect_own_user", nullable = false)
    private User ownUser;

    @OneToMany(mappedBy = "proyect", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stage> stage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwnUser() {
        return this.ownUser;
    }

    public void setOwnUser(User user) {
        this.ownUser = user;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    public List<Stage> getStage() {
        return stage;
    }
}

