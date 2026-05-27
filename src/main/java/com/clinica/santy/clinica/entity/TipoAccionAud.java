package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoaccionaud")
public class TipoAccionAud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAccion")
    private Integer idTipoAccion;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public TipoAccionAud() {}

    // Constructor para crear objetos (opcional)
    public TipoAccionAud(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdTipoAccion() {
        return idTipoAccion;
    }

    public void setIdTipoAccion(Integer idTipoAccion) {
        this.idTipoAccion = idTipoAccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

