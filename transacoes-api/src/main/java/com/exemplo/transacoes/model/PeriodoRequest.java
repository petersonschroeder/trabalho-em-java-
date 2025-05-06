package com.exemplo.transacoes.model;

import java.time.OffsetDateTime;

public class PeriodoRequest {
    private OffsetDateTime dataInicial;
    private OffsetDateTime dataFinal;

    public PeriodoRequest() {}

    public OffsetDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(OffsetDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public OffsetDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(OffsetDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
}
