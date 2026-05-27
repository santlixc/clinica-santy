package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.Notificacion;
import com.clinica.santy.clinica.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    // Encontrar todas las notificaciones
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    // Encontrar notificación por ID
    public Optional<Notificacion> findById(Integer id) {
        return notificacionRepository.findById(id);
    }

    // Guardar una notificación
    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    // Eliminar una notificación por ID
    public void deleteById(Integer id) {
        notificacionRepository.deleteById(id);
    }
}

