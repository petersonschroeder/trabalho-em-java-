
package com.exemplo.transacoes_api;

import java.time.ZonedDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public List<Transacao> getTodasTransacoes() {
        return transacoes;
    }

    public List<Transacao> getTransacoesUltimos60Segundos() {
        ZonedDateTime limite = ZonedDateTime.now().minusSeconds(60);
        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(limite))
                .toList();
    }

    public EstatisticaResponse calcularEstatisticasUltimos60Segundos() {
        List<Transacao> ultimasTransacoes = getTransacoesUltimos60Segundos();

        DoubleSummaryStatistics stats = ultimasTransacoes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        double sum = stats.getSum();
        double avg = stats.getCount() > 0 ? stats.getAverage() : 0.0;
        double min = stats.getCount() > 0 ? stats.getMin() : 0.0;
        double max = stats.getCount() > 0 ? stats.getMax() : 0.0;
        long count = stats.getCount();

        return new EstatisticaResponse(sum, avg, min, max, count);
    }
}
