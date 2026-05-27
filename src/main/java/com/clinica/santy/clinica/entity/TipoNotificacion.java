package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tiponotificacion")
public class TipoNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoNotif")
    private Integer idTipoNotif;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Constructor por defecto (necesario para JPA)
    public TipoNotificacion() {}

    // Constructor para crear objetos (opcional)
    public TipoNotificacion(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdTipoNotif() {
        return idTipoNotif;
    }

    public void setIdTipoNotif(Integer idTipoNotif) {
        this.idTipoNotif = idTipoNotif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

