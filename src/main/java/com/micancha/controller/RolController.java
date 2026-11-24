package com.micancha.controller;

import com.micancha.entity.RolEntity;
import com.micancha.service.RolService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Ruta 1: GET /roles → todos los roles
    @GetMapping
    public List<RolEntity> getAllRoles() {
        return rolService.findAll();
    }

    // Ruta 2: GET /roles/{id} → un rol por id
    @GetMapping("/{id}")
    public RolEntity getRolById(@PathVariable Long id) {
        return rolService.findById(id);
    }

    // Ruta 3: POST /roles → crear un rol
    @PostMapping
    public RolEntity createRol(@RequestBody RolEntity rol) {
        return rolService.save(rol);
    }

    // Ruta 4: PUT /roles/{id} → editar un rol
    @PutMapping("/{id}")
    public RolEntity updateRol(@PathVariable Long id, @RequestBody RolEntity rol) {
        return rolService.update(id, rol);
    }

    // Ruta 5: DELETE /roles/{id} → eliminar un rol
    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteById(id);
    }
}
