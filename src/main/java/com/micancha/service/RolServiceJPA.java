package com.micancha.service;

import com.micancha.entity.RolEntity;
import com.micancha.repository.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceJPA implements RolService {
    private final RolRepository rolRepository;

    public RolServiceJPA(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public RolEntity findById(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    @Override
    public RolEntity save(RolEntity rolEntity) {
        return rolRepository.save(rolEntity);
    }

    @Override
    public RolEntity update(Long id, RolEntity rolEntity) {
        RolEntity existente = findById(id);
        existente.setTipo(rolEntity.getTipo());
        return rolRepository.save(existente);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol no encontrado con ID: " + id);
        }
        rolRepository.deleteById(id);
    }


    @Override
    public Optional<RolEntity> findByTipo(String tipo) {
        return rolRepository.findByTipoIgnoreCase(tipo);
    }

}
