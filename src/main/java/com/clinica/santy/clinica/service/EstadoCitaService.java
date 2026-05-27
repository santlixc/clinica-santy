package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.EstadoCita;
import com.clinica.santy.clinica.repository.EstadoCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoCitaService {

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    // Encontrar todos los estados de cita
    public List<EstadoCita> findAll() {
        return estadoCitaRepository.findAll();
    }

    // Encontrar estado de cita por ID
    public Optional<EstadoCita> findById(Integer id) {
        return estadoCitaRepository.findById(id);
    }

    // Guardar un estado de cita
    public EstadoCita save(EstadoCita estadoCita) {
        return estadoCitaRepository.save(estadoCita);
    }

    // Eliminar un estado de cita por ID
    public void deleteById(Integer id) {
        estadoCitaRepository.deleteById(id);
    }
}

