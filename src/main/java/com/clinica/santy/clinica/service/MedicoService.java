package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Medico;
import com.clinica.santy.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Encontrar todos los médicos
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    // Encontrar médico por ID
    public Optional<Medico> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    // Guardar un médico
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Eliminar un médico por ID
    public void deleteById(Integer id) {
        medicoRepository.deleteById(id);
    }
}

