package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotif")
    private Integer idNotif;

    @Column(name = "idCita", nullable = false)
    private Integer idCita;

    @Column(name = "idTipoNotif", nullable = false)
    private Integer idTipoNotif;

    @Column(name = "idCanal", nullable = false)
    private Integer idCanal;

    @Column(name = "fechaProgramada", nullable = false)
    private LocalDateTime fechaProgramada;

    @Column(name = "estadoEnvio", nullable = false, length = 50)
    private String estadoEnvio;

    @Column(name = "reintentos")
    private Integer reintentos;

    // Constructor por defecto (necesario para JPA)
    public Notificacion() {}

    // Constructor para crear objetos (opcional)
    public Notificacion(Integer idCita, Integer idTipoNotif, Integer idCanal,
                       LocalDateTime fechaProgramada, String estadoEnvio, Integer reintentos) {
        this.idCita = idCita;
        this.idTipoNotif = idTipoNotif;
        this.idCanal = idCanal;
        this.fechaProgramada = fechaProgramada;
        this.estadoEnvio = estadoEnvio;
        this.reintentos = reintentos;
    }

    // Getters y Setters
    public Integer getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(Integer idNotif) {
        this.idNotif = idNotif;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdTipoNotif() {
        return idTipoNotif;
    }

    public void setIdTipoNotif(Integer idTipoNotif) {
        this.idTipoNotif = idTipoNotif;
    }

    public Integer getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(Integer idCanal) {
        this.idCanal = idCanal;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getReintentos() {
        return reintentos;
    }

    public void setReintentos(Integer reintentos) {
        this.reintentos = reintentos;
    }
}

