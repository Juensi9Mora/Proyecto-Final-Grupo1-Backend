package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DetalleReservaService {
    Page<DetalleReservaDto> getAll(String email, Pageable pageable);
    DetalleReservaDto getById(Long id, String email);
    DetalleReservaDto save(ReservaDto reservaDto, String email);
    DetalleReservaDto update(Long id, ReservaDto reservaDto, String email);
    void delete(Long id,String email);
}
