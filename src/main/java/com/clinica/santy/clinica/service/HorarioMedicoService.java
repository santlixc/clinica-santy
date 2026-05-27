package com.clinica.santy.clinica.service;

import com.clinica.santy.clinica.entity.HorarioMedico;
import com.clinica.santy.clinica.repository.HorarioMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioMedicoService {

    @Autowired
    private HorarioMedicoRepository horarioMedicoRepository;

    // Encontrar todos los horarios médicos
    public List<HorarioMedico> findAll() {
        return horarioMedicoRepository.findAll();
    }

    // Encontrar horario médico por ID
    public Optional<HorarioMedico> findById(Integer id) {
        return horarioMedicoRepository.findById(id);
    }

    // Guardar un horario médico
    public HorarioMedico save(HorarioMedico horarioMedico) {
        return horarioMedicoRepository.save(horarioMedico);
    }

    // Eliminar un horario médico por ID
    public void deleteById(Integer id) {
        horarioMedicoRepository.deleteById(id);
    }
}

