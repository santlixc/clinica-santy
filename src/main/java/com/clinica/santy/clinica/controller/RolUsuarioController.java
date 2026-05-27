package com.clinica.santy.clinica.controller;

import com.clinica.santy.clinica.entity.RolUsuario;
import com.clinica.santy.clinica.service.RolUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-usuario")
public class RolUsuarioController {

    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping
    public List<RolUsuario> getAllRolesUsuario() {
        return rolUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolUsuario> getRolUsuarioById(@PathVariable Integer id) {
        return rolUsuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RolUsuario> createRolUsuario(@RequestBody RolUsuario rolUsuario) {
        RolUsuario created = rolUsuarioService.save(rolUsuario);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolUsuario> updateRolUsuario(@PathVariable Integer id,
                                                       @RequestBody RolUsuario rolUsuario) {
        return rolUsuarioService.findById(id)
                .map(existing -> {
                    rolUsuario.setIdRol(id);
                    RolUsuario updated = rolUsuarioService.save(rolUsuario);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolUsuario(@PathVariable Integer id) {
        if (rolUsuarioService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        rolUsuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


