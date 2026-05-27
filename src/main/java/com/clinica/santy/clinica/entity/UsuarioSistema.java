package com.clinica.santy.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuariosistema")
public class UsuarioSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "hashCredencial", nullable = false, length = 255)
    private String hashCredencial;

    @Column(name = "idRol", nullable = false)
    private Integer idRol;

    @Column(name = "nombreCompleto", length = 150)
    private String nombreCompleto;

    // Constructor por defecto (necesario para JPA)
    public UsuarioSistema() {}

    // Constructor para crear objetos (opcional)
    public UsuarioSistema(String usuario, String hashCredencial, Integer idRol, String nombreCompleto) {
        this.usuario = usuario;
        this.hashCredencial = hashCredencial;
        this.idRol = idRol;
        this.nombreCompleto = nombreCompleto;
    }

    // Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getHashCredencial() {
        return hashCredencial;
    }

    public void setHashCredencial(String hashCredencial) {
        this.hashCredencial = hashCredencial;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}

