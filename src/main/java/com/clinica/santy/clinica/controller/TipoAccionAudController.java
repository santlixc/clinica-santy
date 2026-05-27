package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.TipoAccionAud;
import com.clinica.santy.clinica.service.TipoAccionAudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-accion-aud")
public class TipoAccionAudController {

    private final TipoAccionAudService tipoAccionAudService;

    public TipoAccionAudController(TipoAccionAudService tipoAccionAudService) {
        this.tipoAccionAudService = tipoAccionAudService;
    }

    @GetMapping
    public List<TipoAccionAud> getAllTiposAccionAud() {
        return tipoAccionAudService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAccionAud> getTipoAccionAudById(@PathVariable Integer id) {
        return tipoAccionAudService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoAccionAud> createTipoAccionAud(@RequestBody TipoAccionAud tipoAccionAud) {
        TipoAccionAud created = tipoAccionAudService.save(tipoAccionAud);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAccionAud> updateTipoAccionAud(@PathVariable Integer id,
                                                             @RequestBody TipoAccionAud tipoAccionAud) {
        return tipoAccionAudService.findById(id)
                .map(existing -> {
                    tipoAccionAud.setIdTipoAccion(id);
                    TipoAccionAud updated = tipoAccionAudService.save(tipoAccionAud);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoAccionAud(@PathVariable Integer id) {
        if (tipoAccionAudService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoAccionAudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


