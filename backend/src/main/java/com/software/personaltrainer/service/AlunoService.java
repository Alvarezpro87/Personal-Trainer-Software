package com.software.personaltrainer.service;

import com.software.personaltrainer.model.Aluno;
import com.software.personaltrainer.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno getAlunoByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public Aluno updateAluno(String cpf, Aluno alunoDetails) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno == null) {
            return null;
        }
        aluno.setNome(alunoDetails.getNome());
        aluno.setEmail(alunoDetails.getEmail());
        aluno.setWhatsapp(alunoDetails.getWhatsapp());
        aluno.setHorarioTreino(alunoDetails.getHorarioTreino());
        aluno.setAcademia(alunoDetails.getAcademia());
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno != null) {
            alunoRepository.delete(aluno);
        }
    }
}
