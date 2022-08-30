package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    @DisplayName("Deve criar um cliente com um CPF valido")
    void criarClienteCpfValido() {
        //Given
        // CPF Valido: 942.688.010-06

        //When //Then
        Assertions.assertDoesNotThrow(() -> {
            Cliente cliente = new Cliente("Fulano", "94268801006");
        }, "CPF Invalido");
    }

    @Test
    @DisplayName("Deve lançar exceção na criação de um cliente com CPF inválido")
    void criarClienteCpfInvalido() {
        //Given
        // CPF Invalido: 000.000.000-00

        //When //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cliente cliente = new Cliente("Fulano", "00000000000");
        }, "CPF Invalido");
    }

    @Test
    @DisplayName("Deve conseguir criar uma conta e gerar um número altomático")
    void criarContaGerandoNumero() {
        //Given
        Cliente cliente = new Cliente("Batman", "94268801006");
        Long expectedResult = 1L;

        //When
        cliente.criarConta(3200.99);
        Long result = cliente.getContas().get(0).getNumero();

        //Then
        Assertions.assertEquals(expectedResult, result);
    }


}
