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

import br.com.debugsystem.investment.entities.Purchase;
import br.com.debugsystem.investment.services.PurchaseService;

@RestController
@RequestMapping(path = "/api/v1/purchase")
public class PurchaseController {
    
    @Autowired
    public PurchaseService purchaseService;
    
    @GetMapping("{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Long id) {
        Purchase byId = purchaseService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Purchase purchase) {
        purchaseService.savePurchase(purchase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}