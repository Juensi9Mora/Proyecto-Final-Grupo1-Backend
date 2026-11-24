package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.entity.DetalleReservaEntity;

import java.util.List;

public interface DetalleReservaService {
    List<DetalleReservaDto> getAll();
    DetalleReservaDto getById(Long id);
    DetalleReservaDto save(DetalleReservaDto detalleReservaDto);
    DetalleReservaDto update(Long id, DetalleReservaDto detalleReservaDto);
    void delete(Long id);
}
