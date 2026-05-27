package com.clinica.santy.clinica.repository;

import com.clinica.santy.clinica.entity.CanalNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanalNotificacionRepository extends JpaRepository<CanalNotificacion, Integer> {
}

