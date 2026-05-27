package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Medico;
import com.clinica.santy.clinica.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Integer id) {
        return medicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        Medico created = medicoService.save(medico);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Integer id,
                                               @RequestBody Medico medico) {
        return medicoService.findById(id)
                .map(existing -> {
                    medico.setIdMedico(id);
                    Medico updated = medicoService.save(medico);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Integer id) {
        if (medicoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


