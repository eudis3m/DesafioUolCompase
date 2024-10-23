package org.example.Service;

import org.example.Modelo.Pagamento;
import org.example.status.PagamentoStatus;

public class PagamentoService {
    private VendedorService vendedorService = new VendedorService();
    private CobrancaService cobrancaService = new CobrancaService();
    private FilaSqsService filaSqsService = new FilaSqsService();

    public Pagamento processarPagamento(String codigoVendedor, Pagamento pagamento) {
        if (!vendedorService.validarVendedor(codigoVendedor)) {
            throw new IllegalArgumentException("Vendedor não encontrado");
        }

        double valorOriginal = cobrancaService.obterValorOriginal(pagamento.getCodigoCobranca());
        double valorPago = pagamento.getValor();

        if (valorPago < valorOriginal) {
            pagamento.setStatus(PagamentoStatus.PARCIAL);
            filaSqsService.enviarParaFila("fila_parcial", pagamento);
        } else if (valorPago == valorOriginal) {
            pagamento.setStatus(PagamentoStatus.TOTAL);
            filaSqsService.enviarParaFila("fila_total", pagamento);
        } else {
            pagamento.setStatus(PagamentoStatus.EXCEDENTE);
            filaSqsService.enviarParaFila("fila_excedente", pagamento);
        }

        return pagamento;
    }
}

