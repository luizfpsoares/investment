package br.com.debugsystem.investment.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.debugsystem.investment.entities.Active;

public interface ActiveRepository extends JpaRepository<Active, Long> {
    
}
