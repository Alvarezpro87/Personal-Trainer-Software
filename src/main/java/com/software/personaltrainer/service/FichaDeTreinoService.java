package com.software.personaltrainer.service;

import com.software.personaltrainer.model.FichaDeTreino;
import com.software.personaltrainer.model.Aluno;
import com.software.personaltrainer.repository.FichaDeTreinoRepository;
import com.software.personaltrainer.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaDeTreinoService {

    @Autowired
    private FichaDeTreinoRepository fichaDeTreinoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<FichaDeTreino> getAllFichasDeTreino() {
        return fichaDeTreinoRepository.findAll();
    }

    public FichaDeTreino createFichaDeTreino(FichaDeTreino fichaDeTreino) {
        return fichaDeTreinoRepository.save(fichaDeTreino);
    }

    public FichaDeTreino getFichaDeTreinoById(Long id) {
        return fichaDeTreinoRepository.findById(id).orElse(null);
    }

    public List<FichaDeTreino> getFichasDeTreinoByCpf(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno == null) {
            return null;
        }
        return fichaDeTreinoRepository.findByAlunoId(aluno.getId());
    }

    public FichaDeTreino updateFichaDeTreino(Long id, FichaDeTreino fichaDeTreinoDetails) {
        FichaDeTreino fichaDeTreino = fichaDeTreinoRepository.findById(id).orElse(null);
        if (fichaDeTreino == null) {
            return null;
        }
        fichaDeTreino.setDataCriacao(fichaDeTreinoDetails.getDataCriacao());
        fichaDeTreino.setDescricao(fichaDeTreinoDetails.getDescricao());
        return fichaDeTreinoRepository.save(fichaDeTreino);
    }

    public void deleteFichaDeTreino(Long id) {
        fichaDeTreinoRepository.deleteById(id);
    }
}
