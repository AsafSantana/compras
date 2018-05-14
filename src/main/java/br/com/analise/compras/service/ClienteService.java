package br.com.analise.compras.service;

import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.Entity.Cliente;
import br.com.analise.compras.repository.CategoriaRepository;
import br.com.analise.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientepository;

    public Cliente buscarClientePorId(Integer id){

        return clientepository.findOne(id);
    }

}
