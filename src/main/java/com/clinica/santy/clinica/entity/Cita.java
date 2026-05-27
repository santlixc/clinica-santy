package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private Integer idCita;

    @Column(name = "idPaciente", nullable = false)
    private Integer idPaciente;

    @Column(name = "idMedico", nullable = false)
    private Integer idMedico;

    @Column(name = "idFranja", nullable = false)
    private Integer idFranja;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaProgramada", nullable = false)
    private LocalDateTime fechaProgramada;

    @Column(name = "idEstadoCita", nullable = false)
    private Integer idEstadoCita;

    @Column(name = "motivo", length = 255)
    private String motivo;

    // Constructor por defecto (necesario para JPA)
    public Cita() {}

    // Constructor para crear objetos (opcional)
    public Cita(Integer idPaciente, Integer idMedico, Integer idFranja, 
                LocalDateTime fechaCreacion, LocalDateTime fechaProgramada, 
                Integer idEstadoCita, String motivo) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idFranja = idFranja;
        this.fechaCreacion = fechaCreacion;
        this.fechaProgramada = fechaProgramada;
        this.idEstadoCita = idEstadoCita;
        this.motivo = motivo;
    }

    // Getters y Setters
    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdFranja() {
        return idFranja;
    }

    public void setIdFranja(Integer idFranja) {
        this.idFranja = idFranja;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Integer getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

