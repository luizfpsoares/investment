package br.com.debugsystem.investment.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.AccountDTO;
import br.com.debugsystem.investment.dtos.AccountRequestDTO;
import br.com.debugsystem.investment.dtos.ClientSummaryDTO;
import br.com.debugsystem.investment.entities.Account;
import br.com.debugsystem.investment.enums.OriginApportEnum;
import br.com.debugsystem.investment.infra.AccountRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountDTO getById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));
        return convertToDTO(account);
    }

    //LEGADO
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void createAccount(AccountRequestDTO accountRequest) {
        Account account = new Account();

        account.setType(accountRequest.getType());
        account.setBalance(accountRequest.getBalance());
        account.setBalanceMonthlyApportOnly(accountRequest.getBalanceMonthlyApportOnly());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = LocalDate.now().format(formatter);
        account.setDtOpening(currentDate);
        account.setClient(accountRequest.getClient());
        accountRepository.save(account);
    }

    public void updateAccount(Account account, Long id) {
        Account exist = accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));
        exist.setType(account.getType());
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateBalance(Account account, Double value, OriginApportEnum originApport) {
        Account exist = accountRepository.findById(account.getId()).orElseThrow();
        exist.updateBalance(value);
        if (originApport == OriginApportEnum.MONTHLY) {
            exist.updateBalanceMonthlyApportOnly(value);
            accountRepository.save(exist); 
        }
        else
            accountRepository.save(exist);
    }

    private AccountDTO convertToDTO(Account account) {
        ClientSummaryDTO clientSummary = new ClientSummaryDTO(account.getClient().getId(), account.getClient().getName());

        return new AccountDTO(
            account.getId(),
            account.getType().toString(),
            account.getBalance(),
            account.getBalanceMonthlyApportOnly(),
            account.getDtOpening(),
            clientSummary
            );
    }

}
