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

import br.com.debugsystem.investment.dtos.AccountDTO;
import br.com.debugsystem.investment.dtos.AccountRequestDTO;
import br.com.debugsystem.investment.entities.Account;
import br.com.debugsystem.investment.services.AccountService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {
    
    @Autowired
    public AccountService accountService;

    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        AccountDTO byId = accountService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AccountRequestDTO account) {
        accountService.createAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> putMethodName(@PathVariable Long id, @RequestBody Account active) {
        accountService.updateAccount(active, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
