package com.micancha.dto;

import com.micancha.entity.UsuarioEntity;

public record UsuarioDto(Long id, String nombre, String telefono, String email, String estado, RolDto rol) {
    public static UsuarioDto fromEntity(UsuarioEntity usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getEstado(),
                usuario.getRol() != null ? RolDto.fromEntity(usuario.getRol()) : null
        );
    }
}
