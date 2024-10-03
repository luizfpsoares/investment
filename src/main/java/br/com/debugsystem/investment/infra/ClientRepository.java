package br.com.debugsystem.investment.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.debugsystem.investment.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client>{
    
    Client findByCpf(String cpf);
}
