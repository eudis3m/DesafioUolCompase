package org.example.testeUnitarios;

import org.example.Modelo.Pagamento;
import org.example.Service.PagamentoService;
import org.example.status.PagamentoStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagamentoServiceTest {

    private PagamentoService pagamentoService = new PagamentoService();

    @Test
    public void testPagamentoParcial() {
        Pagamento pagamento = new Pagamento("cobranca1", 50.0);
        Pagamento resultado = pagamentoService.processarPagamento("123", pagamento);
        Assertions.assertEquals(PagamentoStatus.PARCIAL, resultado.getStatus());
    }

    @Test
    public void testPagamentoTotal() {
        Pagamento pagamento = new Pagamento("cobranca1", 100.0);
        Pagamento resultado = pagamentoService.processarPagamento("123", pagamento);
        Assertions.assertEquals(PagamentoStatus.TOTAL, resultado.getStatus());
    }

    @Test
    public void testPagamentoExcedente() {
        Pagamento pagamento = new Pagamento("cobranca1", 150.0);
        Pagamento resultado = pagamentoService.processarPagamento("123", pagamento);
        Assertions.assertEquals(PagamentoStatus.EXCEDENTE, resultado.getStatus());
    }

    @Test
    public void testVendedorNaoEncontrado() {
        Pagamento pagamento = new Pagamento("cobranca1", 100.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pagamentoService.processarPagamento("999", pagamento);
        });
    }

    @Test
    public void testCobrancaNaoEncontrada() {
        Pagamento pagamento = new Pagamento("cobranca_invalida", 100.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pagamentoService.processarPagamento("123", pagamento);
        });
    }
}

