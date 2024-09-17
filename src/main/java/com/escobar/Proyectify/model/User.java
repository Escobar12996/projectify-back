/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escobar.Proyectify.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author escobar
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    public static final int MINUSERNAME = 5;
    public static final int MAXUSERNAME = 20;
    public static final int MINUSERRNAME = 2;
    public static final int MAXUSERRNAME = 60;
    public static final int MINUSERRLASTNAME = 2;
    public static final int MAXUSERRLASTNAME = 60;
    public static final int MINEMAIL = 5;
    public static final int MAXEMAIL = 200;
    public static final int MINPASSWORD = 5;
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = MAXUSERNAME, name = "user_username", nullable = false)
    private String username;

    @Column(length = 10000, name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_enabled", nullable = false)
    private Boolean enabled;

    @Column(length = MAXUSERRNAME, name = "user_name", nullable = false)
    private String name;

    @Column(length = MAXUSERRLASTNAME, name = "user_lastname", nullable = false)
    private String lastName;

    @Column(length = MAXEMAIL, unique = true, name = "user_email", nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "user_id", "role_id" }) })
    private List<Rol> roles;

    @Column(name = "user_expired", nullable = false)
    private boolean expired;
    
    @Column(name = "user_locked", nullable = false)
    private boolean locked;
    
    @Column(name = "user_credentials_expired", nullable = false)
    private boolean credentialsExpired;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
    
    
}

