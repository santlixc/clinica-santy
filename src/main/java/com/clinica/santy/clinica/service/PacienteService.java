package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Paciente;
import com.clinica.santy.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Encontrar todos los pacientes
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    // Encontrar paciente por ID
    public Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    // Guardar un paciente
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Eliminar un paciente por ID
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
}

