package com.software.personaltrainer.controller;

import com.software.personaltrainer.model.Pagamento;
import com.software.personaltrainer.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoService.getAllPagamentos();
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.createPagamento(pagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getPagamentoById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.getPagamentoById(id);
        if (pagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoDetails) {
        Pagamento updatedPagamento = pagamentoService.updatePagamento(id, pagamentoDetails);
        if (updatedPagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        pagamentoService.deletePagamento(id);
        return ResponseEntity.noContent().build();
    }
}
