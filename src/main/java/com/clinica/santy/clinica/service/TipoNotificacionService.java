package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.TipoNotificacion;
import com.clinica.santy.clinica.repository.TipoNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoNotificacionService {

    @Autowired
    private TipoNotificacionRepository tipoNotificacionRepository;

    // Encontrar todos los tipos de notificación
    public List<TipoNotificacion> findAll() {
        return tipoNotificacionRepository.findAll();
    }

    // Encontrar tipo de notificación por ID
    public Optional<TipoNotificacion> findById(Integer id) {
        return tipoNotificacionRepository.findById(id);
    }

    // Guardar un tipo de notificación
    public TipoNotificacion save(TipoNotificacion tipoNotificacion) {
        return tipoNotificacionRepository.save(tipoNotificacion);
    }

    // Eliminar un tipo de notificación por ID
    public void deleteById(Integer id) {
        tipoNotificacionRepository.deleteById(id);
    }
}

