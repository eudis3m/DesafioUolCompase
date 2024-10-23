package org.example.Modelo;

import org.example.status.PagamentoStatus;

public class Pagamento {
    private String codigoCobranca;
    private double valor;
    private PagamentoStatus status;

    // Construtores, getters e setters
    public Pagamento(String codigoCobranca, double valor) {
        this.codigoCobranca = codigoCobranca;
        this.valor = valor;
    }
    public String getCodigoCobranca() {
        return codigoCobranca;
    }

    public void setCodigoCobranca(String codigoCobranca) {
        this.codigoCobranca = codigoCobranca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public PagamentoStatus getStatus() {
        return status;
    }

    public void setStatus(PagamentoStatus status) {
        this.status = status;
    }
}

