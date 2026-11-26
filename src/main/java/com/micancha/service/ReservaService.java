package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;

import java.util.List;

public interface ReservaService {
    List<ReservaDto> getAll();
    ReservaDto getById(Long id);
    DetalleReservaDto save(DetalleReservaDto detalleReservaDto);
    DetalleReservaDto update(DetalleReservaDto detalleReservaDto);
    void delete(Long id);
}
