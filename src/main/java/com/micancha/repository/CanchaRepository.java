package com.micancha.repository;

import com.micancha.entity.CanchaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<CanchaEntity, Long> {

    // Buscar canchas por estado
    List<CanchaEntity> findByEstado(String estado);
    // Buscar por nombre
    List<CanchaEntity> findByNombreContainingIgnoreCase(String nombre);
    // Buscar por ciudad
    List<CanchaEntity> findByCiudad(String ciudad);
    // Buscar por categoría
    List<CanchaEntity> findByCategoria(String categoria);
    // Buscar por país
    List<CanchaEntity> findByPais(String pais);
    // Buscar por ciudad y categoría
    List<CanchaEntity> findByCiudadAndCategoria(String ciudad, String categoria);
    // Buscar por precio máximo
    List<CanchaEntity> findByPrecioHoraLessThanEqual(BigDecimal precio);
}
