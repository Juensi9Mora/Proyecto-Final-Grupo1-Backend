package com.micancha.repository;

import com.micancha.entity.DetalleReservaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReservaEntity, Long> {

    @Override
    @EntityGraph(attributePaths = "cancha")
    Page<DetalleReservaEntity> findAll(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = "cancha")
    Optional<DetalleReservaEntity> findById(Long id);

    List<DetalleReservaEntity> findByCancha_IdAndFechaReservaAndEstadoNot(
            Long canchaId, LocalDate fechaReserva, String estado);
}
