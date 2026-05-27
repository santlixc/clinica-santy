package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.CanalNotificacion;
import com.clinica.santy.clinica.repository.CanalNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanalNotificacionService {

    @Autowired
    private CanalNotificacionRepository canalNotificacionRepository;

    // Encontrar todos los canales de notificación
    public List<CanalNotificacion> findAll() {
        return canalNotificacionRepository.findAll();
    }

    // Encontrar canal de notificación por ID
    public Optional<CanalNotificacion> findById(Integer id) {
        return canalNotificacionRepository.findById(id);
    }

    // Guardar un canal de notificación
    public CanalNotificacion save(CanalNotificacion canalNotificacion) {
        return canalNotificacionRepository.save(canalNotificacion);
    }


    // Eliminar un canal de notificación por ID
    public void deleteById(Integer id) {
        canalNotificacionRepository.deleteById(id);
    }
}

