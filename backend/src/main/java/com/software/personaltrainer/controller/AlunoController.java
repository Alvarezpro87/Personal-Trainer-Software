package com.software.personaltrainer.controller;

import com.software.personaltrainer.model.Aluno;
import com.software.personaltrainer.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.createAluno(aluno);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Aluno> getAlunoByCpf(@PathVariable(value = "cpf") String cpf) {
        Aluno aluno = alunoService.getAlunoByCpf(cpf);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable(value = "cpf") String cpf, @RequestBody Aluno alunoDetails) {
        Aluno updatedAluno = alunoService.updateAluno(cpf, alunoDetails);
        if (updatedAluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAluno);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteAluno(@PathVariable(value = "cpf") String cpf) {
        alunoService.deleteAluno(cpf);
        return ResponseEntity.noContent().build();
    }
}
