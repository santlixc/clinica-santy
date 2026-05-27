package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Consultorio;
import com.clinica.santy.clinica.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    // Encontrar todos los consultorios
    public List<Consultorio> findAll() {
        return consultorioRepository.findAll();
    }

    // Encontrar consultorio por ID
    public Optional<Consultorio> findById(Integer id) {
        return consultorioRepository.findById(id);
    }

    // Guardar un consultorio
    public Consultorio save(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }

    // Eliminar un consultorio por ID
    public void deleteById(Integer id) {
        consultorioRepository.deleteById(id);
    }
}

