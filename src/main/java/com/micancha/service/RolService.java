package com.micancha.service;

import com.micancha.entity.RolEntity;
import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolEntity> findAll();

    RolEntity findById(Long id);

    RolEntity save(RolEntity rolEntity);

    RolEntity update(Long id, RolEntity rolEntity);

    void deleteById(Long id);

    Optional<RolEntity> findByTipo(String tipo);
}
