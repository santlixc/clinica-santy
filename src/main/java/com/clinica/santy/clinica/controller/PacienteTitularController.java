package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.PacienteTitular;
import com.clinica.santy.clinica.service.PacienteTitularService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes-titulares")
public class PacienteTitularController {

    private final PacienteTitularService pacienteTitularService;

    public PacienteTitularController(PacienteTitularService pacienteTitularService) {
        this.pacienteTitularService = pacienteTitularService;
    }

    @GetMapping
    public List<PacienteTitular> getAllPacienteTitular() {
        return pacienteTitularService.findAll();
    }

    @GetMapping("/{idPaciente}/{idTitular}")
    public ResponseEntity<PacienteTitular> getPacienteTitularById(@PathVariable Integer idPaciente,
                                                                  @PathVariable Integer idTitular) {
        PacienteTitular.PacienteTitularId id = new PacienteTitular.PacienteTitularId(idPaciente, idTitular);
        return pacienteTitularService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PacienteTitular> createPacienteTitular(@RequestBody PacienteTitular pacienteTitular) {
        PacienteTitular created = pacienteTitularService.save(pacienteTitular);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{idPaciente}/{idTitular}")
    public ResponseEntity<PacienteTitular> updatePacienteTitular(@PathVariable Integer idPaciente,
                                                                 @PathVariable Integer idTitular,
                                                                 @RequestBody PacienteTitular pacienteTitular) {
        PacienteTitular.PacienteTitularId id = new PacienteTitular.PacienteTitularId(idPaciente, idTitular);
        return pacienteTitularService.findById(id)
                .map(existing -> {
                    pacienteTitular.setIdPaciente(idPaciente);
                    pacienteTitular.setIdTitular(idTitular);
                    PacienteTitular updated = pacienteTitularService.save(pacienteTitular);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idPaciente}/{idTitular}")
    public ResponseEntity<Void> deletePacienteTitular(@PathVariable Integer idPaciente,
                                                      @PathVariable Integer idTitular) {
        PacienteTitular.PacienteTitularId id = new PacienteTitular.PacienteTitularId(idPaciente, idTitular);
        if (pacienteTitularService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pacienteTitularService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


