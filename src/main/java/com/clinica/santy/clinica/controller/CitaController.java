package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Cita;
import com.clinica.santy.clinica.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Integer id) {
        return citaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita created = citaService.save(cita);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Integer id,
                                           @RequestBody Cita cita) {
        return citaService.findById(id)
                .map(existing -> {
                    cita.setIdCita(id);
                    Cita updated = citaService.save(cita);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        if (citaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


