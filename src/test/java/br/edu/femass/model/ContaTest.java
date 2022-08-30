package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ContaTest {

    @Test
    void creditarValorConta() {
        Conta conta = new Conta(10D);
        conta.creditar(30D);
        Assertions.assertNotNull(conta.getSaldo());
    }

    @Test
    void debitarValorContaComSaldo() {
          Conta conta = new Conta (20D);
          conta.creditar(20D);
          conta.debitar(10D);


        Assertions.assertTrue(conta.getSaldo() > 0, "É possivel realizar o saque nessa conta");

    }

    @Test
    void debitarValorContaSemSaldo() {
        Conta conta = new Conta(30D);
        conta.debitar(20D);

        Assertions.assertTrue(conta.getSaldo() < 0, "Não existe dinheiro disponivel para saque");
    }

    @Test
    void validarHistoricoLancamentos() {

    }

}