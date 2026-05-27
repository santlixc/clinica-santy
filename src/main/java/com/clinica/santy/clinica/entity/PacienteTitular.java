package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pacientetitular")
@IdClass(PacienteTitular.PacienteTitularId.class)
public class PacienteTitular {

    @Id
    @Column(name = "idPaciente", nullable = false)
    private Integer idPaciente;

    @Id
    @Column(name = "idTitular", nullable = false)
    private Integer idTitular;

    @Column(name = "tipoRelacion", length = 50)
    private String tipoRelacion;

    // Constructor por defecto (necesario para JPA)
    public PacienteTitular() {}

    // Constructor para crear objetos (opcional)
    public PacienteTitular(Integer idPaciente, Integer idTitular, String tipoRelacion) {
        this.idPaciente = idPaciente;
        this.idTitular = idTitular;
        this.tipoRelacion = tipoRelacion;
    }

    // Getters y Setters
    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    // Clase de clave primaria compuesta
    public static class PacienteTitularId implements Serializable {
        private Integer idPaciente;
        private Integer idTitular;

        public PacienteTitularId() {}

        public PacienteTitularId(Integer idPaciente, Integer idTitular) {
            this.idPaciente = idPaciente;
            this.idTitular = idTitular;
        }

        public Integer getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(Integer idPaciente) {
            this.idPaciente = idPaciente;
        }

        public Integer getIdTitular() {
            return idTitular;
        }

        public void setIdTitular(Integer idTitular) {
            this.idTitular = idTitular;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PacienteTitularId that = (PacienteTitularId) o;
            return Objects.equals(idPaciente, that.idPaciente) &&
                   Objects.equals(idTitular, that.idTitular);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idPaciente, idTitular);
        }
    }
}

