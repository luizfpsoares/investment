package br.com.debugsystem.investment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.debugsystem.investment.entities.Active;
import br.com.debugsystem.investment.services.ActiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/active")
public class ActiveController {
    
    @Autowired
    public ActiveService activeService;
    
    @GetMapping("{id}")
    public ResponseEntity<Active> getActive(@PathVariable Long id) {
        Active byId = activeService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Active active) {
        activeService.saveActive(active);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    

}
