package com.software.personaltrainer.repository;

import com.software.personaltrainer.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
