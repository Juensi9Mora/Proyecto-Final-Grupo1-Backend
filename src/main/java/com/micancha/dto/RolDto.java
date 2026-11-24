package com.micancha.dto;

import com.micancha.entity.RolEntity;

public record RolDto(Long id, String tipo) {
    public static RolDto fromEntity(RolEntity rol) {
        return new RolDto(rol.getId(), rol.getTipo());
}
}
