package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.RolUsuario;
import com.clinica.santy.clinica.repository.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    // Encontrar todos los roles de usuario
    public List<RolUsuario> findAll() {
        return rolUsuarioRepository.findAll();
    }

    // Encontrar rol de usuario por ID
    public Optional<RolUsuario> findById(Integer id) {
        return rolUsuarioRepository.findById(id);
    }

    // Guardar un rol de usuario
    public RolUsuario save(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }

    // Eliminar un rol de usuario por ID
    public void deleteById(Integer id) {
        rolUsuarioRepository.deleteById(id);
    }
}

