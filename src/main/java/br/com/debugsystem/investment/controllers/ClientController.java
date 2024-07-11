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

import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.services.ClientService;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {
    
    @Autowired
    public ClientService clientService;
    
    @GetMapping("{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Client byId = clientService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Client client) {
        clientService.saveClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
