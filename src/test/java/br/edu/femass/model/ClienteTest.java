package br.edu.femass.model;

import br.edu.femass.utils.Cpf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void criarClienteCpfValido() {
        Assertions.assertTrue(Cpf.isCpf("95081465089"));
    }

    @Test
    void criarClienteCpfInvalido() {
        Assertions.assertFalse(Cpf.isCpf("1387493984"));
    }

    @Test
    void criarContaGerandoNumero() {

    }


}
