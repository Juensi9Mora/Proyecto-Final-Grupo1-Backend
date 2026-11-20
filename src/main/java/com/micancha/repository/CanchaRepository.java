package com.micancha.repository;

import com.micancha.entity.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {

    List<Cancha> findByNombreContainingIgnoreCase(String nombre);
    List<Cancha> findByCiudadIgnoreCase(String ciudad);
    List<Cancha> findByCategoriaIgnoreCase(String categoria);
    List<Cancha> findByEstadoIgnoreCase(String estado);
}
