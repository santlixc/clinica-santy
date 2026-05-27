package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Especialidad;
import com.clinica.santy.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    // Encontrar todas las especialidades
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    // Encontrar especialidad por ID
    public Optional<Especialidad> findById(Integer id) {
        return especialidadRepository.findById(id);
    }

    // Guardar una especialidad
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    // Eliminar una especialidad por ID
    public void deleteById(Integer id) {
        especialidadRepository.deleteById(id);
    }
}

