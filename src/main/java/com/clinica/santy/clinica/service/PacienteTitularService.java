package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.PacienteTitular;
import com.clinica.santy.clinica.repository.PacienteTitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteTitularService {

    @Autowired
    private PacienteTitularRepository pacienteTitularRepository;

    // Encontrar todas las relaciones paciente-titular
    public List<PacienteTitular> findAll() {
        return pacienteTitularRepository.findAll();
    }

    // Encontrar relación paciente-titular por ID compuesto
    public Optional<PacienteTitular> findById(PacienteTitular.PacienteTitularId id) {
        return pacienteTitularRepository.findById(id);
    }

    // Guardar una relación paciente-titular
    public PacienteTitular save(PacienteTitular pacienteTitular) {
        return pacienteTitularRepository.save(pacienteTitular);
    }

    // Eliminar una relación paciente-titular por ID compuesto
    public void deleteById(PacienteTitular.PacienteTitularId id) {
        pacienteTitularRepository.deleteById(id);
    }
}

