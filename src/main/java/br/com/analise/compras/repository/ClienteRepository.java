package br.com.analise.compras.repository;

import br.com.analise.compras.Entity.Cliente;
import br.com.analise.compras.Entity.Endereco;
import com.sun.deploy.util.SessionState.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
