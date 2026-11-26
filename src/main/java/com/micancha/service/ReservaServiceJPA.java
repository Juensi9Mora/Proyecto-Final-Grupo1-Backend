package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;
import com.micancha.mapper.ReservaMapper;
import com.micancha.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceJPA implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    public ReservaServiceJPA(ReservaRepository reservaRepository, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public List<ReservaDto> getAll() {
        return List.of();
    }

    @Override
    public ReservaDto getById(Long id) {
        return null;
    }

    @Override
    public DetalleReservaDto save(DetalleReservaDto detalleReservaDto) {
        return null;
    }

    @Override
    public DetalleReservaDto update(DetalleReservaDto detalleReservaDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
