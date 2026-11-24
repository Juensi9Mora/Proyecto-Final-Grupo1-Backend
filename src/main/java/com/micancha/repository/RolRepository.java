package com.micancha.repository;

import com.micancha.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
    Optional<RolEntity> findByTipoIgnoreCase(String tipo);

}
