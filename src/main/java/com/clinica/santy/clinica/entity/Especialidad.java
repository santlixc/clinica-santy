package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    // El campo de llave primaria de tu tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad")
    private Integer idEspecialidad;

    // El campo 'nombre'
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // 3. Getters y Setters (Necesarios para JPA y para serializar/deserializar JSON)

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Constructor por defecto (necesario para JPA)
    public Especialidad() {}

    // Constructor para crear objetos (opcional)
    public Especialidad(String nombre) {
        this.nombre = nombre;
    }
}
