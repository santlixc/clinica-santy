package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedico")
    private Integer idMedico;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "idEspecialidad", nullable = false)
    private Integer idEspecialidad;

    // Constructor por defecto (necesario para JPA)
    public Medico() {}

    // Constructor para crear objetos (opcional)
    public Medico(String nombre, Integer idEspecialidad) {
        this.nombre = nombre;
        this.idEspecialidad = idEspecialidad;
    }

    // Getters y Setters
    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}

