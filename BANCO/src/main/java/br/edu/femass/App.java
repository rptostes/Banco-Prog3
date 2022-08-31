package br.edu.femass;

import br.edu.femass.dao.DaoCliente;
import br.edu.femass.model.Cliente;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Da Silva","68954346073");
        DaoCliente dao = new DaoCliente();
        try{
            dao.gravar(cliente);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Cliente cliente2 = new Cliente("Maria","05095463075");
        cliente2.criarConta(0.0);
        cliente2.criarConta(1000.0);

        cliente2.getContas().get(0).creditar(1000.0);
        cliente2.getContas().get(0).creditar(500.0);
        cliente2.getContas().get(0).debitar(200.0);

        try{
            dao.gravar(cliente2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
