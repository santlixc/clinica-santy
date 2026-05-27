package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.CanalNotificacion;
import com.clinica.santy.clinica.service.CanalNotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canales")
public class CanalNotificacionController {

    private final CanalNotificacionService canalNotificacionService;

    public CanalNotificacionController(CanalNotificacionService canalNotificacionService) {
        this.canalNotificacionService = canalNotificacionService;
    }

    @GetMapping
    public List<CanalNotificacion> getAllCanales() {
        return canalNotificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanalNotificacion> getCanalById(@PathVariable Integer id) {
        return canalNotificacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CanalNotificacion> createCanal(@RequestBody CanalNotificacion canal) {
        CanalNotificacion created = canalNotificacionService.save(canal);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CanalNotificacion> updateCanal(@PathVariable Integer id,
                                                         @RequestBody CanalNotificacion canal) {
        return canalNotificacionService.findById(id)
                .map(existing -> {
                    canal.setIdCanal(id);
                    CanalNotificacion updated = canalNotificacionService.save(canal);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCanal(@PathVariable Integer id) {
        if (canalNotificacionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        canalNotificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


