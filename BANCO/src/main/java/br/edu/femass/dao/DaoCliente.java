package br.edu.femass.dao;


import br.edu.femass.model.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {

    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public void gravar(Cliente cliente) throws Exception{
        clientes.add(cliente);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientes);
        System.out.println(json);

        FileOutputStream out = new FileOutputStream("cliente.json");
        out.write(json.getBytes());
        out.close();
    }
    public List<Cliente> getClientes() throws Exception{
        FileInputStream in = new FileInputStream("cliente.json");
        String json = new String(in.readAllBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(json, new TypeReference<List<Cliente>>(){});

        return clientes;
    }

}
