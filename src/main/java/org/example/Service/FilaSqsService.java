package org.example.Service;

import org.example.Modelo.Pagamento;

public class FilaSqsService {
    public void enviarParaFila(String fila, Pagamento pagamento) {
        // Lógica fictícia para enviar para uma fila SQS
        System.out.println("Enviado para fila: " + fila + " - Pagamento: " + pagamento.getCodigoCobranca());
    }
}

