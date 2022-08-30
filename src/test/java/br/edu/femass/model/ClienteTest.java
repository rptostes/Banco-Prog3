package br.edu.femass.model;

import br.edu.femass.utils.Cpf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void criarClienteCpfValido() {
        Assertions.assertTrue(Cpf.isCpf("93810535028"));
    }

    @Test
    void criarClienteCpfInvalido() {
        Assertions.assertTrue(Cpf.isCpf("93810535029"));
    }

    @Test
    void criarContaGerandoNumero() {
        Cliente cliente = new Cliente(
                "Jose Silva",
                "93810535028");
        cliente.criarConta(1000D);
        Conta conta = cliente.getContas().get(0);
        Long esperado = 1L;
        Assertions.assertEquals(esperado, conta.getNumero());
    }


}
