package br.com.debugsystem.investment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.debugsystem.investment.dtos.ActiveDTO;
import br.com.debugsystem.investment.entities.Active;
import br.com.debugsystem.investment.services.ActiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/api/v1/actives")
public class ActiveController {
    
    @Autowired
    public ActiveService activeService;

    @GetMapping
    public ResponseEntity<List<ActiveDTO>> findAll(){
        List<ActiveDTO> allActives = activeService.findAll();
        return new ResponseEntity<>(allActives, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ActiveDTO> getActive(@PathVariable Long id) {
        ActiveDTO byId = activeService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Active active) {
        activeService.saveActive(active);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> putMethodName(@PathVariable Long id, @RequestBody Active active) {
        activeService.updateActive(active, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
