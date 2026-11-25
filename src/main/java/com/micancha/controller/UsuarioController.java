package com.micancha.controller;

import com.micancha.dto.UsuarioDto;
import com.micancha.entity.UsuarioEntity;
import com.micancha.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Ruta 1: GET /usuarios → todos
    @GetMapping
    public List<UsuarioDto> getAllUsuarios() {
        return usuarioService.findAll()
                .stream()
                .map(UsuarioDto::fromEntity)
                .toList();
    }

    // Ruta 2: GET /usuarios/{id} → uno por id
    @GetMapping("/{id}")
    public UsuarioDto getUsuarioById(@PathVariable Long id) {
        return UsuarioDto.fromEntity(usuarioService.findById(id));
    }

    // Ruta 3: POST /usuarios → crear
    @PostMapping
    public UsuarioDto createUsuario(@RequestBody UsuarioEntity usuario) {
        return UsuarioDto.fromEntity(usuarioService.save(usuario));
    }

    // Ruta 4: PUT /usuarios/{id} → editar
    @PutMapping("/{id}")
    public UsuarioDto updateUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        return UsuarioDto.fromEntity(usuarioService.update(id, usuario));
    }

    // Ruta 5: DELETE /usuarios/{id} → eliminar
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
