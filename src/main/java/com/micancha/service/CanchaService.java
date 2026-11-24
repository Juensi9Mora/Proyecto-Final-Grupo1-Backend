package com.micancha.service;

import com.micancha.entity.CanchaEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CanchaService {

    List<CanchaEntity> findAll();
    CanchaEntity findById(Long id);
    CanchaEntity save(CanchaEntity cancha);
    CanchaEntity update(Long id, CanchaEntity cancha);
    void deleteById(Long id);
    List<CanchaEntity> findByEstado(String estado);
    List<CanchaEntity> findByNombre(String nombre);
    List<CanchaEntity> findByCiudad(String ciudad);
    List<CanchaEntity> findByCategoria(String categoria);
    List<CanchaEntity> findByPais(String pais);
    List<CanchaEntity> findByCiudadAndCategoria(String ciudad, String categoria);
    List<CanchaEntity> findByPrecioHoraLessThanEqual(BigDecimal precio);
}
