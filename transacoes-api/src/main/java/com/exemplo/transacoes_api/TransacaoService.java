package com.exemplo.transacoes_api;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
}
