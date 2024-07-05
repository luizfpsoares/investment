package br.com.debugsystem.investment.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.debugsystem.investment.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
