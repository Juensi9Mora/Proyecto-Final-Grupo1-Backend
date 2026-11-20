package com.micancha.service;

import com.micancha.entity.Cancha;
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
    public List<Cancha> findAll() {
        return canchaRepository.findAll();
    }

    @Override
    public Cancha findById(Long id) {
        return canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada con ID: " + id));
    }

    @Override
    public Cancha save(Cancha cancha) {
        if (cancha.getEstado() == null || cancha.getEstado().isBlank()) {
            cancha.setEstado("ACTIVA");
        };
        return canchaRepository.save(cancha);
    }

    @Override
    public Cancha update(Long id, Cancha canchaActualizada) {
        Cancha existente = canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada con ID: " + id));

        existente.setNombre(canchaActualizada.getNombre());
        existente.setImagenUrl(canchaActualizada.getImagenUrl());
        existente.setDescripcion(canchaActualizada.getDescripcion());
        existente.setDireccion(canchaActualizada.getDireccion());
        existente.setDireccionUrl(canchaActualizada.getDireccionUrl());
        existente.setPais(canchaActualizada.getPais());
        existente.setCiudad(canchaActualizada.getCiudad());
        existente.setCategoria(canchaActualizada.getCategoria());
        existente.setPrecioHora(canchaActualizada.getPrecioHora());
        existente.setEstado(canchaActualizada.getEstado());

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
    public List<Cancha> findByNombre(String nombre) {
        return canchaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Cancha> findByCiudad(String ciudad) {
        return canchaRepository.findByCiudadIgnoreCase(ciudad);
    }

    @Override
    public List<Cancha> findByCategoria(String categoria) {
        return canchaRepository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public List<Cancha> findByEstado(String estado) {
        return canchaRepository.findByEstadoIgnoreCase(estado);
    }
}
