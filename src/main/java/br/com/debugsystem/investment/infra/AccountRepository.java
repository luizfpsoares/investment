package br.com.debugsystem.investment.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.debugsystem.investment.entities.Account;

public interface AccountRepository  extends JpaRepository<Account, Long> {
    
}
