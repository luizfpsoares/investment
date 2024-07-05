package br.com.debugsystem.investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.entities.Account;
import br.com.debugsystem.investment.infra.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void updateAccount(Account account, Long id) {
        Account exist = accountRepository.findById(id).orElseThrow();
        exist.setType(account.getType());
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateBalance(Account account, Long value) {
        Account exist = accountRepository.findById(account.getId()).orElseThrow();
        exist.updateBalance(value);
        accountRepository.save(exist);
    }

}
