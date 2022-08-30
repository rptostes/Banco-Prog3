package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void creditarValorConta() {
        Cliente cliente = new Cliente(
                "Rubens Silva",
                "59996483002" );
        cliente.criarConta(0.0);
        Conta conta = cliente.getContas().get(0);
        Double esperado = 2500.0;
        conta.creditar(2500.0);
        Assertions.assertEquals(esperado, conta.getSaldo());

    }

    @Test
    void debitarValorContaComSaldo() {
        Cliente cliente = new Cliente(
                "Rubens Silva",
                "59996483002" );
        cliente.criarConta(0.0);
        Conta conta = cliente.getContas().get(0);
        Double esperado = 500.0;
        conta.creditar(2500.0);
        conta.debitar(2000.0);
        Assertions.assertEquals(esperado, conta.getSaldo());
    }

    @Test
    void debitarValorContaSemSaldo() throws Exception {
        Cliente cliente = new Cliente(
                "Rubens Silva",
                "59996483002" );
        cliente.criarConta(10.0);
        Conta conta = cliente.getContas().get(0);
        String esperado = "Saldo Insuficiente";
        try {
            conta.creditar(100.0);
            conta.debitar(1200.0);
        } catch (IllegalArgumentException ex) {
            conta.getSaldo();
        }
    }

    @Test
    void validarHistoricoLancamentos() {

    }

}