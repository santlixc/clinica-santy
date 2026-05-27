package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.EstadoFranja;
import com.clinica.santy.clinica.repository.EstadoFranjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoFranjaService {

    @Autowired
    private EstadoFranjaRepository estadoFranjaRepository;

    // Encontrar todos los estados de franja
    public List<EstadoFranja> findAll() {
        return estadoFranjaRepository.findAll();
    }

    // Encontrar estado de franja por ID
    public Optional<EstadoFranja> findById(Integer id) {
        return estadoFranjaRepository.findById(id);
    }

    // Guardar un estado de franja
    public EstadoFranja save(EstadoFranja estadoFranja) {
        return estadoFranjaRepository.save(estadoFranja);
    }

    // Eliminar un estado de franja por ID
    public void deleteById(Integer id) {
        estadoFranjaRepository.deleteById(id);
    }
}

