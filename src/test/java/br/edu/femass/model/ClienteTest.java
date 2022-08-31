package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void criarClienteCpfValido() {
        Cliente cliente = new Cliente("Lucas Siqueira", "931.241.330-99");
        String esperado = "931.241.330-99";

        Assertions.assertEquals(esperado, cliente.getCpf());
    }

    @Test
    void criarClienteCpfInvalido() {
        String esperado = "CPF Inválido";
        String atual = "";

        try{
            Cliente cliente = new Cliente("Lucas Siqueira", "931.241.330-90");
        }
        catch (IllegalArgumentException erro){
            atual = erro.getMessage();
        }
        finally {
            Assertions.assertEquals(esperado, atual);
        }
    }

    @Test
    void criarContaGerandoNumero() {
        Cliente cliente = new Cliente("Lucas Siqueira", "931.241.330-99");
        cliente.criarConta(1000D);

        String esperado = "1";

        Assertions.assertEquals(esperado, cliente.getContas().get(0).toString());
    }


}
