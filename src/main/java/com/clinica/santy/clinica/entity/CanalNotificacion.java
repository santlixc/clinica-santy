package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "canalnotificacion")
public class CanalNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCanal")
    private Integer idCanal;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public CanalNotificacion() {}

    // Constructor para crear objetos (opcional)
    public CanalNotificacion(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(Integer idCanal) {
        this.idCanal = idCanal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

