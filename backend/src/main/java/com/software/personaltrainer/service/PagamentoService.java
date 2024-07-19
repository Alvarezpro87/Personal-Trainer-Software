package com.software.personaltrainer.service;

import com.software.personaltrainer.model.Pagamento;
import com.software.personaltrainer.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento createPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento getPagamentoById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento updatePagamento(Long id, Pagamento pagamentoDetails) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);
        if (pagamento == null) {
            return null;
        }
        pagamento.setDataPagamento(pagamentoDetails.getDataPagamento());
        pagamento.setValor(pagamentoDetails.getValor());
        pagamento.setMetodoPagamento(pagamentoDetails.getMetodoPagamento());
        return pagamentoRepository.save(pagamento);
    }

    public void deletePagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
