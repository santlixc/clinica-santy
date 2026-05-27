package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.FranjaHoraria;
import com.clinica.santy.clinica.repository.FranjaHorariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranjaHorariaService {

    @Autowired
    private FranjaHorariaRepository franjaHorariaRepository;

    // Encontrar todas las franjas horarias
    public List<FranjaHoraria> findAll() {
        return franjaHorariaRepository.findAll();
    }

    // Encontrar franja horaria por ID
    public Optional<FranjaHoraria> findById(Integer id) {
        return franjaHorariaRepository.findById(id);
    }

    // Guardar una franja horaria
    public FranjaHoraria save(FranjaHoraria franjaHoraria) {
        return franjaHorariaRepository.save(franjaHoraria);
    }

    // Eliminar una franja horaria por ID
    public void deleteById(Integer id) {
        franjaHorariaRepository.deleteById(id);
    }
}

