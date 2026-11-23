package com.micancha.service;

import com.micancha.entity.CanchaEntity;

import java.util.List;

public interface CanchaService {

    List<CanchaEntity> findAll();
    CanchaEntity findById(Long id);
    CanchaEntity save(CanchaEntity canchaEntity);
    CanchaEntity update(Long id, CanchaEntity canchaEntity);
    void deleteById(Long id);
    List<CanchaEntity> findByNombre(String nombre);
    List<CanchaEntity> findByCiudad(String ciudad);
    List<CanchaEntity> findByCategoria(String categoria);
    List<CanchaEntity> findByEstado(String estado);
}
