package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.FranjaHoraria;
import com.clinica.santy.clinica.service.FranjaHorariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franjas-horarias")
public class FranjaHorariaController {

    private final FranjaHorariaService franjaHorariaService;

    public FranjaHorariaController(FranjaHorariaService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
    }

    @GetMapping
    public List<FranjaHoraria> getAllFranjasHorarias() {
        return franjaHorariaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranjaHoraria> getFranjaHorariaById(@PathVariable Integer id) {
        return franjaHorariaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FranjaHoraria> createFranjaHoraria(@RequestBody FranjaHoraria franjaHoraria) {
        FranjaHoraria created = franjaHorariaService.save(franjaHoraria);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranjaHoraria> updateFranjaHoraria(@PathVariable Integer id,
                                                             @RequestBody FranjaHoraria franjaHoraria) {
        return franjaHorariaService.findById(id)
                .map(existing -> {
                    franjaHoraria.setIdFranja(id);
                    FranjaHoraria updated = franjaHorariaService.save(franjaHoraria);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranjaHoraria(@PathVariable Integer id) {
        if (franjaHorariaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        franjaHorariaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


