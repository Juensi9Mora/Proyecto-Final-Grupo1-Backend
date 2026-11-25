package com.micancha.service;

import com.micancha.entity.UsuarioEntity;
import com.micancha.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceJPA implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceJPA(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();

    }

    @Override
    public UsuarioEntity findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        if (findByEmail(usuarioEntity.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con el email: " + usuarioEntity.getEmail());
        }
        if (usuarioEntity.getEstado() == null || usuarioEntity.getEstado().isBlank()) {
            usuarioEntity.setEstado("ACTIVO");
        }
        return usuarioRepository.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity usuarioEntity) {
        UsuarioEntity existente = findById(id);
        if (!existente.getEmail().equalsIgnoreCase(usuarioEntity.getEmail())
                && findByEmail(usuarioEntity.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con el email: " + usuarioEntity.getEmail());
        }
        //Cambiar un set por atributo
        existente.setNombre(usuarioEntity.getNombre());
        existente.setTelefono(usuarioEntity.getTelefono());
        existente.setEmail(usuarioEntity.getEmail());
        existente.setEstado(usuarioEntity.getEstado());
        existente.setRol(usuarioEntity.getRol());

        if (usuarioEntity.getContrasena() != null && !usuarioEntity.getContrasena().isBlank()) {
            existente.setContrasena(usuarioEntity.getContrasena());
        }
        return usuarioRepository.save(existente);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioEntity> findByEmail(String email) {
        return usuarioRepository.findByEmailIgnoreCase(email);
    }
}

