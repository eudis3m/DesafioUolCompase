package org.example.Service;

public class CobrancaService {
    public double obterValorOriginal(String codigoCobranca) {
        // Lógica fictícia para obter o valor original da cobrança
        if ("cobranca1".equals(codigoCobranca)) {
            return 100.0;
        }
        throw new IllegalArgumentException("Cobrança não encontrada");
    }
}

