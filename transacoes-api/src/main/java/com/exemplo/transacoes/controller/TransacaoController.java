package com.exemplo.transacoes.controller;

import com.exemplo.transacoes.model.Transacao;
import com.exemplo.transacoes.model.Estatistica;
import com.exemplo.transacoes.model.PeriodoRequest;
import com.exemplo.transacoes.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> receberTransacao(@RequestBody Transacao transacao) {
        if (transacao.getValor() < 0 || transacao.getDataHora() == null || transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transacaoService.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ultima")
    public ResponseEntity<Transacao> ultimaTransacao() {
        Transacao ultima = transacaoService.obterUltimaTransacao();
        return (ultima != null) ? ResponseEntity.ok(ultima) : ResponseEntity.noContent().build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Estatistica> estatisticasRecentes() {
        Estatistica estatistica = transacaoService.calcularEstatisticasRecentes();
        return ResponseEntity.ok(estatistica);
    }

    @PostMapping("/periodo")
    public ResponseEntity<Estatistica> estatisticasPeriodo(@RequestBody PeriodoRequest periodo) {
        Estatistica estatistica = transacaoService.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatistica);
    }

    @DeleteMapping("/periodo")
    public ResponseEntity<Void> excluirPorPeriodo(@RequestBody PeriodoRequest periodo) {
        boolean removido = transacaoService.excluirTransacoesPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return removido ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }
}
