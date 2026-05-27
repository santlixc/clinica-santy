package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.Titular;
import com.clinica.santy.clinica.service.TitularService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

    private final TitularService titularService;

    public TitularController(TitularService titularService) {
        this.titularService = titularService;
    }

    @GetMapping
    public List<Titular> getAllTitulares() {
        return titularService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Titular> getTitularById(@PathVariable Integer id) {
        return titularService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Titular> createTitular(@RequestBody Titular titular) {
        Titular created = titularService.save(titular);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Titular> updateTitular(@PathVariable Integer id,
                                                 @RequestBody Titular titular) {
        return titularService.findById(id)
                .map(existing -> {
                    titular.setIdTitular(id);
                    Titular updated = titularService.save(titular);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitular(@PathVariable Integer id) {
        if (titularService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        titularService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


