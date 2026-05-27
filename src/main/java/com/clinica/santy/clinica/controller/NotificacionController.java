package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Notificacion;
import com.clinica.santy.clinica.service.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return notificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> getNotificacionById(@PathVariable Integer id) {
        return notificacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notificacion> createNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion created = notificacionService.save(notificacion);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> updateNotificacion(@PathVariable Integer id,
                                                           @RequestBody Notificacion notificacion) {
        return notificacionService.findById(id)
                .map(existing -> {
                    notificacion.setIdNotif(id);
                    Notificacion updated = notificacionService.save(notificacion);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacion(@PathVariable Integer id) {
        if (notificacionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        notificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


