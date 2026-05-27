package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.HorarioMedico;
import com.clinica.santy.clinica.service.HorarioMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios-medico")
public class HorarioMedicoController {

    private final HorarioMedicoService horarioMedicoService;

    public HorarioMedicoController(HorarioMedicoService horarioMedicoService) {
        this.horarioMedicoService = horarioMedicoService;
    }

    @GetMapping
    public List<HorarioMedico> getAllHorariosMedico() {
        return horarioMedicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioMedico> getHorarioMedicoById(@PathVariable Integer id) {
        return horarioMedicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HorarioMedico> createHorarioMedico(@RequestBody HorarioMedico horarioMedico) {
        HorarioMedico created = horarioMedicoService.save(horarioMedico);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioMedico> updateHorarioMedico(@PathVariable Integer id,
                                                             @RequestBody HorarioMedico horarioMedico) {
        return horarioMedicoService.findById(id)
                .map(existing -> {
                    horarioMedico.setIdHorario(id);
                    HorarioMedico updated = horarioMedicoService.save(horarioMedico);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioMedico(@PathVariable Integer id) {
        if (horarioMedicoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        horarioMedicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


