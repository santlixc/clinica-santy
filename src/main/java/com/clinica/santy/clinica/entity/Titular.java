package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "titular")
public class Titular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitular")
    private Integer idTitular;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "documento", nullable = false, length = 50)
    private String documento;

    @Column(name = "contacto", length = 100)
    private String contacto;

    // Constructor por defecto (necesario para JPA)
    public Titular() {}

    // Constructor para crear objetos (opcional)
    public Titular(String nombre, String documento, String contacto) {
        this.nombre = nombre;
        this.documento = documento;
        this.contacto = contacto;
    }

    // Getters y Setters
    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}

