package com.micancha.service;

import com.micancha.entity.CanchaEntity;
import com.micancha.repository.CanchaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Primary
public class CanchaServiceJPA implements CanchaService {

    private final CanchaRepository canchaRepository;

    @Autowired
    public CanchaServiceJPA(CanchaRepository canchaRepository) {
        this.canchaRepository = canchaRepository;
    }

    @Override
    public List<CanchaEntity> findAll() {
        return canchaRepository.findAll();
    }

    @Override
    public CanchaEntity findById(Long id) {
        return canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada con ID: " + id));
    }

    @Override
    @Transactional
    public CanchaEntity save(CanchaEntity cancha) {
        cancha.setEstado("ACTIVA");

        return canchaRepository.save(cancha);
    }

    @Override
    @Transactional
    public CanchaEntity update(Long id, CanchaEntity canchaActualizada) {

        CanchaEntity existente = canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada con ID: " + id)
                );

        existente.setNombre(canchaActualizada.getNombre());
        existente.setImagenUrl(canchaActualizada.getImagenUrl());
        existente.setDescripcion(canchaActualizada.getDescripcion());
        existente.setDireccion(canchaActualizada.getDireccion());
        existente.setDireccionUrl(canchaActualizada.getDireccionUrl());
        existente.setPais(canchaActualizada.getPais());
        existente.setCiudad(canchaActualizada.getCiudad());
        existente.setCategoria(canchaActualizada.getCategoria());
        existente.setPrecioHora(canchaActualizada.getPrecioHora());

        if (canchaActualizada.getEstado() != null) {
            existente.setEstado(canchaActualizada.getEstado());
        }
        return canchaRepository.save(existente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        if (!canchaRepository.existsById(id)) {
            throw new RuntimeException("Cancha no encontrada con ID: " + id);
        }
        canchaRepository.deleteById(id);
    }

    @Override
    public List<CanchaEntity> findByEstado(String estado) {
        return canchaRepository.findByEstado(estado);
    }

    @Override
    public List<CanchaEntity> findByNombre(String nombre) {
        return canchaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<CanchaEntity> findByCiudad(String ciudad) {
        return canchaRepository.findByCiudad(ciudad);
    }

    @Override
    public List<CanchaEntity> findByCategoria(String categoria) {
        return canchaRepository.findByCategoria(categoria);
    }

    @Override
    public List<CanchaEntity> findByPais(String pais) {
        return canchaRepository.findByPais(pais);
    }

    @Override
    public List<CanchaEntity> findByCiudadAndCategoria(String ciudad, String categoria) {
        return canchaRepository.findByCiudadAndCategoria(ciudad, categoria);
    }

    @Override
    public List<CanchaEntity> findByPrecioHoraLessThanEqual(BigDecimal precio) {
        return canchaRepository.findByPrecioHoraLessThanEqual(precio);
    }
}