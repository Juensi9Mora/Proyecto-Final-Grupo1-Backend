package com.micancha.service;

import com.micancha.entity.DetalleReservaEntity;
import com.micancha.repository.DetalleReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReservaServiceJPA implements DetalleReservaService {

    private final DetalleReservaRepository detalleReservaRepository;

    public DetalleReservaServiceJPA(DetalleReservaRepository detalleReservaRepository) {
        this.detalleReservaRepository = detalleReservaRepository;
    }

    @Override
    public List<DetalleReservaEntity> getAll() {
        return this.detalleReservaRepository.findAll();
    }

    @Override
    public DetalleReservaEntity getById(Long id) {
        return null;
    }

    @Override
    public DetalleReservaEntity save(DetalleReservaEntity detalleReservaEntity) {
        return null;
    }

    @Override
    public DetalleReservaEntity update(Long id, DetalleReservaEntity detalleReservaEntity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
