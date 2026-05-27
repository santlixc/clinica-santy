package com.clinica.santy.clinica.repository;

import com.clinica.santy.clinica.entity.FranjaHoraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranjaHorariaRepository extends JpaRepository<FranjaHoraria, Integer> {
}

