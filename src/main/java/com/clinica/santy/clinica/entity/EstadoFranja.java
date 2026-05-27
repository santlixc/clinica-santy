package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estadofranja")
public class EstadoFranja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoFranja")
    private Integer idEstadoFranja;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public EstadoFranja() {}

    // Constructor para crear objetos (opcional)
    public EstadoFranja(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdEstadoFranja() {
        return idEstadoFranja;
    }

    public void setIdEstadoFranja(Integer idEstadoFranja) {
        this.idEstadoFranja = idEstadoFranja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

