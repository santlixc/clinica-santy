package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.UsuarioSistema;
import com.clinica.santy.clinica.repository.UsuarioSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioSistemaRepository usuarioRepository;

    // Encontrar todos los usuarios
    public List<UsuarioSistema> findAll() {
        return usuarioRepository.findAll();
    }

    // Encontrar usuario por ID
    public Optional<UsuarioSistema> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un usuario
    public UsuarioSistema save(UsuarioSistema usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

