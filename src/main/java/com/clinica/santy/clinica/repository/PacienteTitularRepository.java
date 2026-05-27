package com.clinica.santy.clinica.repository;

import com.clinica.santy.clinica.entity.PacienteTitular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteTitularRepository extends JpaRepository<PacienteTitular, PacienteTitular.PacienteTitularId> {
}

