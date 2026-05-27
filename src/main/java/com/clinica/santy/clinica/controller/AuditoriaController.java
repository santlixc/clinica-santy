package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Auditoria;
import com.clinica.santy.clinica.service.AuditoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @GetMapping
    public List<Auditoria> getAllAuditorias() {
        return auditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditoria> getAuditoriaById(@PathVariable Integer id) {
        return auditoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Auditoria> createAuditoria(@RequestBody Auditoria auditoria) {
        Auditoria created = auditoriaService.save(auditoria);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auditoria> updateAuditoria(@PathVariable Integer id,
                                                     @RequestBody Auditoria auditoria) {
        return auditoriaService.findById(id)
                .map(existing -> {
                    auditoria.setIdAud(id);
                    Auditoria updated = auditoriaService.save(auditoria);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditoria(@PathVariable Integer id) {
        if (auditoriaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        auditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


