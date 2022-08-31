package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void creditarValorConta() {
        Conta conta = new Conta(0D);
        Double valorEsperado = 1000D;
        conta.creditar(1000D);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    void debitarValorContaComSaldo() {
        Conta conta = new Conta(0D);
        Double valorEsperado = 900D;
        conta.creditar(1000D);
        conta.debitar(100D);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    void debitarValorContaSemSaldo() {
        String esperado = "Saldo Insuficiente";
        String atual = "";

        try {
            Conta conta = new Conta(0D);
            conta.creditar(1000D);
            conta.debitar(1001D);
        }
        catch (IllegalArgumentException erro){
            atual = erro.getMessage();
        }
        finally {
            Assertions.assertEquals(esperado, atual);
        }
    }

    @Test
    void validarHistoricoLancamentos() {
        Conta conta = new Conta(0D);
        String esperado = "";

        conta.creditar(1000D);
        esperado = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                    + " - Valor: 1000.0 - Crédito\n";
        conta.debitar(100D);
        esperado += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                + " - Valor: 100.0 - Débito\n";

        Assertions.assertEquals(esperado, conta.getHistorico());
    }

}