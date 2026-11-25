package com.micancha.service;

import com.micancha.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioEntity> findAll();
    UsuarioEntity findById (Long id);
    UsuarioEntity save(UsuarioEntity usuarioEntity);
    UsuarioEntity update(Long id, UsuarioEntity usuarioEntity);
    void deleteById(Long id);
    Optional<UsuarioEntity> findByEmail(String email);}

