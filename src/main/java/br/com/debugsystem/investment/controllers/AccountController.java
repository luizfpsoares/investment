package br.com.debugsystem.investment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.debugsystem.investment.entities.Account;
import br.com.debugsystem.investment.services.AccountService;

@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {
    
    @Autowired
    public AccountService accountService;

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Account byId = accountService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Account account) {
        accountService.saveAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
