package com.software.personaltrainer.repository;

import com.software.personaltrainer.model.FichaDeTreino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichaDeTreinoRepository extends JpaRepository<FichaDeTreino, Long> {
    List<FichaDeTreino> findByAlunoId(Long alunoId);
}
