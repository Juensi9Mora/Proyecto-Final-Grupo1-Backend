package com.micancha.repository;

import com.micancha.entity.DetalleReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReservaEntity, Long> {
}
