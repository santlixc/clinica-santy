package com.clinica.santy.clinica.repository;

import com.clinica.santy.clinica.entity.HorarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioMedicoRepository extends JpaRepository<HorarioMedico, Integer> {
}

