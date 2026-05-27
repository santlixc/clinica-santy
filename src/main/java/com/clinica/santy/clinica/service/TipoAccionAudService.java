package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.TipoAccionAud;
import com.clinica.santy.clinica.repository.TipoAccionAudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAccionAudService {

    @Autowired
    private TipoAccionAudRepository tipoAccionAudRepository;

    // Encontrar todos los tipos de acción de auditoría
    public List<TipoAccionAud> findAll() {
        return tipoAccionAudRepository.findAll();
    }

    // Encontrar tipo de acción de auditoría por ID
    public Optional<TipoAccionAud> findById(Integer id) {
        return tipoAccionAudRepository.findById(id);
    }

    // Guardar un tipo de acción de auditoría
    public TipoAccionAud save(TipoAccionAud tipoAccionAud) {
        return tipoAccionAudRepository.save(tipoAccionAud);
    }

    // Eliminar un tipo de acción de auditoría por ID
    public void deleteById(Integer id) {
        tipoAccionAudRepository.deleteById(id);
    }
}

