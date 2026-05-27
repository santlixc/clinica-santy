package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Auditoria;
import com.clinica.santy.clinica.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    // Encontrar todos los registros de auditoría
    public List<Auditoria> findAll() {
        return auditoriaRepository.findAll();
    }

    // Encontrar auditoría por ID
    public Optional<Auditoria> findById(Integer id) {
        return auditoriaRepository.findById(id);
    }

    // Guardar un registro de auditoría
    public Auditoria save(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    // Eliminar un registro de auditoría por ID
    public void deleteById(Integer id) {
        auditoriaRepository.deleteById(id);
    }
}

