package com.software.personaltrainer.service;

import com.software.personaltrainer.model.Matricula;
import com.software.personaltrainer.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> getAllMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula createMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public Matricula getMatriculaById(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public Matricula updateMatricula(Long id, Matricula matriculaDetails) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);
        if (matricula == null) {
            return null;
        }
        matricula.setDataInicio(matriculaDetails.getDataInicio());
        matricula.setDataFim(matriculaDetails.getDataFim());
        matricula.setPlano(matriculaDetails.getPlano());
        return matriculaRepository.save(matricula);
    }

    public void deleteMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}
