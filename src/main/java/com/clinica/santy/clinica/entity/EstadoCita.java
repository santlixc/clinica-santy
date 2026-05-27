package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estadocita")
public class EstadoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCita")
    private Integer idEstadoCita;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public EstadoCita() {}

    // Constructor para crear objetos (opcional)
    public EstadoCita(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

