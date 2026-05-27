package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Especialidad;
import com.clinica.santy.clinica.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Integer id) {
        return especialidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad created = especialidadService.save(especialidad);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Integer id,
                                                           @RequestBody Especialidad especialidad) {
        return especialidadService.findById(id)
                .map(existing -> {
                    especialidad.setIdEspecialidad(id);
                    Especialidad updated = especialidadService.save(especialidad);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Integer id) {
        if (especialidadService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        especialidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


