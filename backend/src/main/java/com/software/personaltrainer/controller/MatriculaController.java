package com.software.personaltrainer.controller;

import com.software.personaltrainer.model.Matricula;
import com.software.personaltrainer.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> getAllMatriculas() {
        return matriculaService.getAllMatriculas();
    }

    @PostMapping
    public Matricula createMatricula(@RequestBody Matricula matricula) {
        return matriculaService.createMatricula(matricula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable Long id) {
        Matricula matricula = matriculaService.getMatriculaById(id);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> updateMatricula(@PathVariable Long id, @RequestBody Matricula matriculaDetails) {
        Matricula updatedMatricula = matriculaService.updateMatricula(id, matriculaDetails);
        if (updatedMatricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMatricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable Long id) {
        matriculaService.deleteMatricula(id);
        return ResponseEntity.noContent().build();
    }
}
