package com.exemplo.transacoes.service;

import com.exemplo.transacoes.model.Transacao;
import com.exemplo.transacoes.model.Estatistica;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public Estatistica calcularEstatisticasRecentes() {
        OffsetDateTime agora = OffsetDateTime.now();
        List<Transacao> ultimasTransacoes = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(60)))
                .collect(Collectors.toList());

        return calcularEstatisticas(ultimasTransacoes);
    }

    public Estatistica calcularEstatisticasPorPeriodo(OffsetDateTime inicio, OffsetDateTime fim) {
        List<Transacao> transacoesPeriodo = transacoes.stream()
                .filter(t -> !t.getDataHora().isBefore(inicio) && !t.getDataHora().isAfter(fim))
                .collect(Collectors.toList());

        return calcularEstatisticas(transacoesPeriodo);
    }

    public Transacao obterUltimaTransacao() {
        return transacoes.stream()
                .max((t1, t2) -> t1.getDataHora().compareTo(t2.getDataHora()))
                .orElse(null);
    }

    public boolean excluirTransacoesPorPeriodo(OffsetDateTime inicio, OffsetDateTime fim) {
        return transacoes.removeIf(t -> !t.getDataHora().isBefore(inicio) && !t.getDataHora().isAfter(fim));
    }

    private Estatistica calcularEstatisticas(List<Transacao> transacoes) {
        if (transacoes.isEmpty()) {
            return new Estatistica(0, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics stats = transacoes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new Estatistica(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
