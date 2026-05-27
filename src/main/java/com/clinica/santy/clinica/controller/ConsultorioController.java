package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Consultorio;
import com.clinica.santy.clinica.service.ConsultorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping
    public List<Consultorio> getAllConsultorios() {
        return consultorioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorio> getConsultorioById(@PathVariable Integer id) {
        return consultorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Consultorio> createConsultorio(@RequestBody Consultorio consultorio) {
        Consultorio created = consultorioService.save(consultorio);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultorio> updateConsultorio(@PathVariable Integer id,
                                                         @RequestBody Consultorio consultorio) {
        return consultorioService.findById(id)
                .map(existing -> {
                    consultorio.setIdConsultorio(id);
                    Consultorio updated = consultorioService.save(consultorio);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultorio(@PathVariable Integer id) {
        if (consultorioService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        consultorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


