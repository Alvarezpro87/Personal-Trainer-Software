package com.software.personaltrainer.service;

import com.software.personaltrainer.model.AvaliacaoFisica;
import com.software.personaltrainer.model.Aluno;
import com.software.personaltrainer.repository.AvaliacaoFisicaRepository;
import com.software.personaltrainer.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AvaliacaoFisica> getAllAvaliacoesFisicas() {
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisica createAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public AvaliacaoFisica getAvaliacaoFisicaById(Long id) {
        return avaliacaoFisicaRepository.findById(id).orElse(null);
    }

    public List<AvaliacaoFisica> getAvaliacoesFisicasByCpf(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno == null) {
            return null;
        }
        return avaliacaoFisicaRepository.findByAlunoId(aluno.getId());
    }

    public AvaliacaoFisica updateAvaliacaoFisica(Long id, AvaliacaoFisica avaliacaoFisicaDetails) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).orElse(null);
        if (avaliacaoFisica == null) {
            return null;
        }
        avaliacaoFisica.setDataAvaliacao(avaliacaoFisicaDetails.getDataAvaliacao());
        avaliacaoFisica.setPeso(avaliacaoFisicaDetails.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaDetails.getAltura());
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public void deleteAvaliacaoFisica(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
