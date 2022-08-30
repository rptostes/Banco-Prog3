package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    private Conta conta;

    @BeforeEach
    public void setUp() {
        conta = new Conta(0.0);
    }

    @Test
    @DisplayName("Deve conseguir creditar o valor na conta")
    public void creditarValorConta() {
        //Given
        Double expectedResult = 50.53;

        //When
        conta.creditar(50.53);
        Double result = conta.getSaldo();

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Deve conseguir debitar o valor da conta")
    public void debitarValorContaComSaldo() {
        //Given
        Double expectedResult = 54.50;
        conta.creditar(100.0);

        //When
        conta.debitar(45.50);
        Double result = conta.getSaldo();

        // Then
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando tentar debitar com o saldo insuficiente")
    public void debitarValorContaSemSaldo() {
        //Given
        String expectedMessage = "Saldo Insuficiente";
        conta.creditar(100.0);

        //When / Then
        assertThrows(IllegalArgumentException.class,
                () -> conta.debitar(45.50),
                expectedMessage);
    }

    @Test
    @DisplayName("Deve gerar um histórico de transações")
    public void validarHistoricoLancamentos() {
        //Given
        conta.setEspecial(1000.00);
        conta.creditar(304.54);
        conta.creditar(29.45);
        conta.debitar(30.52);

        var expectedResult = conta.getHistorico();
        //When
        var result = conta.getHistorico();

        //Then
        Assertions.assertEquals(expectedResult, result);

    }

}