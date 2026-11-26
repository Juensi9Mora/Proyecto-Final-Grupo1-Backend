package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DetalleReservaService {
    Page<DetalleReservaDto> getAll(Pageable pageable);
    DetalleReservaDto getById(Long id);
    DetalleReservaDto save(ReservaDto reservaDto, Long usuarioId);
    DetalleReservaDto update(Long id, ReservaDto reservaDto);
    void delete(Long id);
}
