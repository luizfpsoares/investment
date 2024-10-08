package br.com.debugsystem.investment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.debugsystem.investment.dtos.PurchaseDTO;
import br.com.debugsystem.investment.entities.Purchase;
import br.com.debugsystem.investment.services.PurchaseService;

@RestController
@RequestMapping(path = "/api/v1/purchases")
public class PurchaseController {
    
    @Autowired
    public PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> findAll(){
        List<PurchaseDTO> allPurchases = purchaseService.findAll();
        return new ResponseEntity<>(allPurchases, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<PurchaseDTO> getPurchase(@PathVariable Long id) {
        PurchaseDTO byId = purchaseService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Purchase purchase) {
        purchaseService.makePurchase(purchase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
