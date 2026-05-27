package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.TipoNotificacion;
import com.clinica.santy.clinica.service.TipoNotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-notificacion")
public class TipoNotificacionController {

    private final TipoNotificacionService tipoNotificacionService;

    public TipoNotificacionController(TipoNotificacionService tipoNotificacionService) {
        this.tipoNotificacionService = tipoNotificacionService;
    }

    @GetMapping
    public List<TipoNotificacion> getAllTiposNotificacion() {
        return tipoNotificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoNotificacion> getTipoNotificacionById(@PathVariable Integer id) {
        return tipoNotificacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoNotificacion> createTipoNotificacion(@RequestBody TipoNotificacion tipoNotificacion) {
        TipoNotificacion created = tipoNotificacionService.save(tipoNotificacion);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoNotificacion> updateTipoNotificacion(@PathVariable Integer id,
                                                                   @RequestBody TipoNotificacion tipoNotificacion) {
        return tipoNotificacionService.findById(id)
                .map(existing -> {
                    tipoNotificacion.setIdTipoNotif(id);
                    TipoNotificacion updated = tipoNotificacionService.save(tipoNotificacion);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoNotificacion(@PathVariable Integer id) {
        if (tipoNotificacionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoNotificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


