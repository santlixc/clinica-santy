package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rolusuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public RolUsuario() {}

    // Constructor para crear objetos (opcional)
    public RolUsuario(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

