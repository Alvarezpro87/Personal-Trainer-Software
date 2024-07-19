package com.software.personaltrainer.controller;

import com.software.personaltrainer.model.AvaliacaoFisica;
import com.software.personaltrainer.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes-fisicas")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping
    public List<AvaliacaoFisica> getAllAvaliacoesFisicas() {
        return avaliacaoFisicaService.getAllAvaliacoesFisicas();
    }

    @PostMapping
    public AvaliacaoFisica createAvaliacaoFisica(@RequestBody AvaliacaoFisica avaliacaoFisica) {
        return avaliacaoFisicaService.createAvaliacaoFisica(avaliacaoFisica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> getAvaliacaoFisicaById(@PathVariable Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.getAvaliacaoFisicaById(id);
        if (avaliacaoFisica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacaoFisica);
    }

    @GetMapping("/cpf/{cpf}")
    public List<AvaliacaoFisica> getAvaliacoesFisicasByCpf(@PathVariable String cpf) {
        return avaliacaoFisicaService.getAvaliacoesFisicasByCpf(cpf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> updateAvaliacaoFisica(@PathVariable Long id, @RequestBody AvaliacaoFisica avaliacaoFisicaDetails) {
        AvaliacaoFisica updatedAvaliacaoFisica = avaliacaoFisicaService.updateAvaliacaoFisica(id, avaliacaoFisicaDetails);
        if (updatedAvaliacaoFisica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAvaliacaoFisica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacaoFisica(@PathVariable Long id) {
        avaliacaoFisicaService.deleteAvaliacaoFisica(id);
        return ResponseEntity.noContent().build();
    }
}
