package com.software.personaltrainer.controller;

import com.software.personaltrainer.model.FichaDeTreino;
import com.software.personaltrainer.service.FichaDeTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas-de-treino")
public class FichaDeTreinoController {

    @Autowired
    private FichaDeTreinoService fichaDeTreinoService;

    @GetMapping
    public List<FichaDeTreino> getAllFichasDeTreino() {
        return fichaDeTreinoService.getAllFichasDeTreino();
    }

    @PostMapping
    public FichaDeTreino createFichaDeTreino(@RequestBody FichaDeTreino fichaDeTreino) {
        return fichaDeTreinoService.createFichaDeTreino(fichaDeTreino);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaDeTreino> getFichaDeTreinoById(@PathVariable Long id) {
        FichaDeTreino fichaDeTreino = fichaDeTreinoService.getFichaDeTreinoById(id);
        if (fichaDeTreino == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fichaDeTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaDeTreino> updateFichaDeTreino(@PathVariable Long id, @RequestBody FichaDeTreino fichaDeTreinoDetails) {
        FichaDeTreino updatedFichaDeTreino = fichaDeTreinoService.updateFichaDeTreino(id, fichaDeTreinoDetails);
        if (updatedFichaDeTreino == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFichaDeTreino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFichaDeTreino(@PathVariable Long id) {
        fichaDeTreinoService.deleteFichaDeTreino(id);
        return ResponseEntity.noContent().build();
    }
}
