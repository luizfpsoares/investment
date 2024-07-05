package br.com.debugsystem.investment.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.debugsystem.investment.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    
}
