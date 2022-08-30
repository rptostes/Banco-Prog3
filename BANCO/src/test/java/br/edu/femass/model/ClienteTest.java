package br.edu.femass.model;

import br.edu.femass.utils.Cpf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void criarClienteCpfValido() {
        Assertions.assertTrue(Cpf.isCpf("70244355002"));
    }

    @Test
    void criarClienteCpfInvalido() {
        Assertions.assertFalse(Cpf.isCpf("70244355333"));
    }

    @Test
    void criarContaGerandoNumero() {
        Cliente cliente = new Cliente(
                "Rubens Silva",
                "59996483002" );
        cliente.criarConta(1000D);
        Conta conta = cliente.getContas().get(0);
        Long esperado = 1L;
        Assertions.assertEquals(esperado, conta.getNumero());
    }


}
