package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    public static final Integer ADMIN = 1;
    public static final Integer USER = 2;
    public static final Integer DEL_USERS = 3;
    public static final Integer BLACKLIST = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private int idRole;

    @Column(name = "roles", nullable = false, unique = true)
    private String role;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
