package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Cita;
import com.clinica.santy.clinica.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    // Encontrar todas las citas
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    // Encontrar cita por ID
    public Optional<Cita> findById(Integer id) {
        return citaRepository.findById(id);
    }

    // Guardar una cita
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    // Eliminar una cita por ID
    public void deleteById(Integer id) {
        citaRepository.deleteById(id);
    }
}

