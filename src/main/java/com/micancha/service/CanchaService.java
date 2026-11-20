package com.micancha.service;

import com.micancha.entity.Cancha;

import java.util.List;

public interface CanchaService {

    List<Cancha> findAll();
    Cancha findById(Long id);
    Cancha save(Cancha cancha);
    Cancha update(Long id, Cancha cancha);
    void deleteById(Long id);
    List<Cancha> findByNombre(String nombre);
    List<Cancha> findByCiudad(String ciudad);
    List<Cancha> findByCategoria(String categoria);
    List<Cancha> findByEstado(String estado);
}
