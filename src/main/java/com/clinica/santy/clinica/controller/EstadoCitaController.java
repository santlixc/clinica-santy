package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.EstadoCita;
import com.clinica.santy.clinica.service.EstadoCitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-cita")
public class EstadoCitaController {

    private final EstadoCitaService estadoCitaService;

    public EstadoCitaController(EstadoCitaService estadoCitaService) {
        this.estadoCitaService = estadoCitaService;
    }

    @GetMapping
    public List<EstadoCita> getAllEstadosCita() {
        return estadoCitaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCita> getEstadoCitaById(@PathVariable Integer id) {
        return estadoCitaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoCita> createEstadoCita(@RequestBody EstadoCita estadoCita) {
        EstadoCita created = estadoCitaService.save(estadoCita);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCita> updateEstadoCita(@PathVariable Integer id,
                                                       @RequestBody EstadoCita estadoCita) {
        return estadoCitaService.findById(id)
                .map(existing -> {
                    estadoCita.setIdEstadoCita(id);
                    EstadoCita updated = estadoCitaService.save(estadoCita);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoCita(@PathVariable Integer id) {
        if (estadoCitaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        estadoCitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


