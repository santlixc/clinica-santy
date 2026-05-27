package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAud")
    private Integer idAud;

    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "idCita", nullable = false)
    private Integer idCita;

    @Column(name = "fechaHora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "idTipoAccion", nullable = false)
    private Integer idTipoAccion;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    // Constructor por defecto (necesario para JPA)
    public Auditoria() {}

    // Constructor para crear objetos (opcional)
    public Auditoria(Integer idUsuario, Integer idCita, LocalDateTime fechaHora, 
                     Integer idTipoAccion, String comentario) {
        this.idUsuario = idUsuario;
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.idTipoAccion = idTipoAccion;
        this.comentario = comentario;
    }

    // Getters y Setters
    public Integer getIdAud() {
        return idAud;
    }

    public void setIdAud(Integer idAud) {
        this.idAud = idAud;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getIdTipoAccion() {
        return idTipoAccion;
    }

    public void setIdTipoAccion(Integer idTipoAccion) {
        this.idTipoAccion = idTipoAccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

