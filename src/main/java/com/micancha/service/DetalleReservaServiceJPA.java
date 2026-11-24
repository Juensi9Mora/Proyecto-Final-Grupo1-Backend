package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.entity.DetalleReservaEntity;
import com.micancha.mapper.DetalleReservaMapper;
import com.micancha.repository.DetalleReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReservaServiceJPA implements DetalleReservaService {

    private final DetalleReservaRepository detalleReservaRepository;
    private final DetalleReservaMapper detalleReservaMapper;

    public DetalleReservaServiceJPA(DetalleReservaRepository detalleReservaRepository, DetalleReservaMapper detalleReservaMapper) {
        this.detalleReservaRepository = detalleReservaRepository;
        this.detalleReservaMapper = detalleReservaMapper;
    }

    @Override
    public List<DetalleReservaDto> getAll() {
        return this.detalleReservaMapper.toDto(detalleReservaRepository.findAll());
    }

    @Override
    public DetalleReservaDto getById(Long id) {
        return this.detalleReservaMapper.toDto(detalleReservaRepository.findById(id).orElse(null));
    }

    @Override
    public DetalleReservaDto save(DetalleReservaDto detalleReservaDto) {
        return null;
    }

    @Override
    public DetalleReservaDto update(Long id, DetalleReservaDto detalleReservaDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
