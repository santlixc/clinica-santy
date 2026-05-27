package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "franjahoraria")
public class FranjaHoraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFranja")
    private Integer idFranja;

    @Column(name = "idMedico", nullable = false)
    private Integer idMedico;

    @Column(name = "idConsultorio", nullable = false)
    private Integer idConsultorio;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "idEstadoFranja", nullable = false)
    private Integer idEstadoFranja;

    // Constructor por defecto (necesario para JPA)
    public FranjaHoraria() {}

    // Constructor para crear objetos (opcional)
    public FranjaHoraria(Integer idMedico, Integer idConsultorio, LocalDate fecha,
                         LocalTime horaInicio, LocalTime horaFin, Integer idEstadoFranja) {
        this.idMedico = idMedico;
        this.idConsultorio = idConsultorio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idEstadoFranja = idEstadoFranja;
    }

    // Getters y Setters
    public Integer getIdFranja() {
        return idFranja;
    }

    public void setIdFranja(Integer idFranja) {
        this.idFranja = idFranja;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getIdEstadoFranja() {
        return idEstadoFranja;
    }

    public void setIdEstadoFranja(Integer idEstadoFranja) {
        this.idEstadoFranja = idEstadoFranja;
    }
}

