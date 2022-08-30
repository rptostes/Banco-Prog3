package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void creditarValorConta() {
        Cliente cliente = new Cliente(
                "João da Silva",
                "65006006064" );
        cliente.criarConta(0D);
        Conta conta = cliente.getContas().get(0);
        conta.creditar(3000D);
        Double esperado = 3000D;
        Assertions.assertEquals(esperado, conta.getSaldo());
    }

    @Test
    void debitarValorContaComSaldo() {
        Cliente cliente = new Cliente(
                "João da Silva",
                "65006006064" );
        cliente.criarConta(0D);
        Conta conta = cliente.getContas().get(0);
        conta.creditar(1000D);
        conta.debitar(500D);
        Double esperado = 500D;
        Assertions.assertEquals(esperado, conta.getSaldo());
    }

    @Test
    void debitarValorContaSemSaldo() {
        Cliente cliente = new Cliente(
                "João da Silva",
                "65006006064" );
        cliente.criarConta(0D);
        Conta conta = cliente.getContas().get(0);
        Double esperado = 0D;
        try {
            conta.debitar(1000D);
        } catch (IllegalArgumentException ex) {
            Assertions.assertEquals(esperado, conta.getSaldo());
        }
    }

    @Test
    void validarHistoricoLancamentos() {
        Cliente cliente = new Cliente(
                "João da Silva",
                "65006006064" );
        cliente.criarConta(0D);
        Conta conta = cliente.getContas().get(0);
        try {
            conta.creditar(2000D);
            conta.debitar(500D);
            conta.debitar(150D);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Saldo da conta: "
                + conta.getSaldo());
        System.out.println("Histórico de operações:\n"
                + conta.getHistorico());
    }

}