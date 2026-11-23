package com.micancha.service;

import com.micancha.entity.CanchaEntity;
import com.micancha.repository.CanchaRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CanchaServiceJPA implements CanchaService{

    private final CanchaRepository canchaRepository;

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
    public CanchaEntity save(CanchaEntity canchaEntity) {
        if (canchaEntity.getEstado() == null || canchaEntity.getEstado().isBlank()) {
            canchaEntity.setEstado("ACTIVA");
        };
        return canchaRepository.save(canchaEntity);
    }

    @Override
    public CanchaEntity update(Long id, CanchaEntity canchaEntityActualizada) {
        CanchaEntity existente = canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada con ID: " + id));

        existente.setNombre(canchaEntityActualizada.getNombre());
        existente.setImagenUrl(canchaEntityActualizada.getImagenUrl());
        existente.setDescripcion(canchaEntityActualizada.getDescripcion());
        existente.setDireccion(canchaEntityActualizada.getDireccion());
        existente.setDireccionUrl(canchaEntityActualizada.getDireccionUrl());
        existente.setPais(canchaEntityActualizada.getPais());
        existente.setCiudad(canchaEntityActualizada.getCiudad());
        existente.setCategoria(canchaEntityActualizada.getCategoria());
        existente.setPrecioHora(canchaEntityActualizada.getPrecioHora());
        existente.setEstado(canchaEntityActualizada.getEstado());

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
    public List<CanchaEntity> findByNombre(String nombre) {
        return canchaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<CanchaEntity> findByCiudad(String ciudad) {
        return canchaRepository.findByCiudadIgnoreCase(ciudad);
    }

    @Override
    public List<CanchaEntity> findByCategoria(String categoria) {
        return canchaRepository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public List<CanchaEntity> findByEstado(String estado) {
        return canchaRepository.findByEstadoIgnoreCase(estado);
    }
}
