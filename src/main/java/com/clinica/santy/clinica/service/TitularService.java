package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Titular;
import com.clinica.santy.clinica.repository.TitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitularService {

    @Autowired
    private TitularRepository titularRepository;

    // Encontrar todos los titulares
    public List<Titular> findAll() {
        return titularRepository.findAll();
    }

    // Encontrar titular por ID
    public Optional<Titular> findById(Integer id) {
        return titularRepository.findById(id);
    }

    // Guardar un titular
    public Titular save(Titular titular) {
        return titularRepository.save(titular);
    }

    // Eliminar un titular por ID
    public void deleteById(Integer id) {
        titularRepository.deleteById(id);
    }
}

