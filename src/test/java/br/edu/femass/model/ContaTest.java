package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void creditarValorConta() {
        Conta conta = new Conta(30000D);
        conta.creditar(232D);
        Assertions.assertEquals(29768D, conta.getSaldo());
    }

    @Test
    void debitarValorContaComSaldo() {
        Conta conta = new Conta(20000D);
        conta.debitar((679D));
        Assertions.assertEquals(-679D, conta.getSaldo());

    }

    @Test
    void debitarValorContaSemSaldo() {
        Conta conta = new Conta(0D);
        conta.debitar(48389D);
        Assertions.assertEquals("Saldo Insuficiente");

    }

    @Test
    void validarHistoricoLancamentos() {
        Conta conta = new Conta(343D);
        conta.getHistorico();
    }

}