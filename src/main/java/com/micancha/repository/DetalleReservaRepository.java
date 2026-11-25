package com.micancha.repository;

import com.micancha.entity.DetalleReservaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReservaEntity, Long> {
    @EntityGraph(attributePaths = "cancha")
    Page<DetalleReservaEntity> findByReserva_UsuarioEntity_Email(String email, Pageable pageable);

    @EntityGraph(attributePaths = "cancha")
    Optional<DetalleReservaEntity> findByIdAndReserva_UsuarioEntity_Email(Long id, String email);
}
