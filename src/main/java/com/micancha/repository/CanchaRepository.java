package com.micancha.repository;

import com.micancha.entity.CanchaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<CanchaEntity, Long> {

    List<CanchaEntity> findByNombreContainingIgnoreCase(String nombre);
    List<CanchaEntity> findByCiudadIgnoreCase(String ciudad);
    List<CanchaEntity> findByCategoriaIgnoreCase(String categoria);
    List<CanchaEntity> findByEstadoIgnoreCase(String estado);
}
