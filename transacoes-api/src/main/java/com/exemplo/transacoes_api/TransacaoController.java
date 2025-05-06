
package com.exemplo.transacoes_api;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}

    @PostMapping
    public ResponseEntity<?> adicionarTransacao(@Valid @RequestBody TransacaoDTO dto) {
        if (dto.getDataHora().isAfter(ZonedDateTime.now())) {
            return ResponseEntity.unprocessableEntity().body("Data futura não permitida");
        

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}

        Transacao transacao = new Transacao(dto.getValor(), dto.getDataHora());
        service.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes() {
        service.limparTransacoes();
        return ResponseEntity.ok().build();
    

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaResponse> getEstatistica() {
        EstatisticaResponse estatisticas = service.calcularEstatisticasUltimos60Segundos();
        return ResponseEntity.ok(estatisticas);
    

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}


    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> getEstatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatistica = service.calcularEstatisticasPorPeriodo(
            periodo.getDataInicial(), periodo.getDataFinal()
        );
        return ResponseEntity.ok(estatistica);
    

    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}


    @PostMapping("/periodo")
    public ResponseEntity<EstatisticaResponse> estatisticasPorPeriodo(@RequestBody PeriodoRequestDTO periodo) {
        EstatisticaResponse estatisticas = service.calcularEstatisticasPorPeriodo(periodo.getDataInicial(), periodo.getDataFinal());
        return ResponseEntity.ok(estatisticas);
    }

}
