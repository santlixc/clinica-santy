package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horariomedico")
public class HorarioMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario")
    private Integer idHorario;

    @Column(name = "idMedico", nullable = false)
    private Integer idMedico;

    @Column(name = "diaSemana", nullable = false, length = 20)
    private String diaSemana;

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "estadoDisponibilidad", nullable = false, length = 50)
    private String estadoDisponibilidad;

    // Constructor por defecto (necesario para JPA)
    public HorarioMedico() {}

    // Constructor para crear objetos (opcional)
    public HorarioMedico(Integer idMedico, String diaSemana, LocalTime horaInicio,
                        LocalTime horaFin, String estadoDisponibilidad) {
        this.idMedico = idMedico;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    // Getters y Setters
    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public String getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(String estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }
}

