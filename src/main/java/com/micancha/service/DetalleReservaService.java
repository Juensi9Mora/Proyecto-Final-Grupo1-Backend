package com.micancha.service;

import com.micancha.entity.DetalleReservaEntity;

import java.util.List;

public interface DetalleReservaService {
    List<DetalleReservaEntity> getAll();
    DetalleReservaEntity getById(Long id);
    DetalleReservaEntity save(DetalleReservaEntity detalleReservaEntity);
    DetalleReservaEntity update(Long id, DetalleReservaEntity detalleReservaEntity);
    void delete(Long id);
}
