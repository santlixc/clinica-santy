package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.EstadoFranja;
import com.clinica.santy.clinica.service.EstadoFranjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-franja")
public class EstadoFranjaController {

    private final EstadoFranjaService estadoFranjaService;

    public EstadoFranjaController(EstadoFranjaService estadoFranjaService) {
        this.estadoFranjaService = estadoFranjaService;
    }

    @GetMapping
    public List<EstadoFranja> getAllEstadosFranja() {
        return estadoFranjaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoFranja> getEstadoFranjaById(@PathVariable Integer id) {
        return estadoFranjaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoFranja> createEstadoFranja(@RequestBody EstadoFranja estadoFranja) {
        EstadoFranja created = estadoFranjaService.save(estadoFranja);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoFranja> updateEstadoFranja(@PathVariable Integer id,
                                                           @RequestBody EstadoFranja estadoFranja) {
        return estadoFranjaService.findById(id)
                .map(existing -> {
                    estadoFranja.setIdEstadoFranja(id);
                    EstadoFranja updated = estadoFranjaService.save(estadoFranja);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoFranja(@PathVariable Integer id) {
        if (estadoFranjaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        estadoFranjaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


