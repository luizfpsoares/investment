package br.com.debugsystem.investment.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.entities.Purchase;
import br.com.debugsystem.investment.infra.PurchaseRepository;

@Service
public class PurchaseService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private AccountService accountService;

     public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    public Purchase getById(Long id) {
        return purchaseRepository.findById(id).orElseThrow();
    }

    public void savePurchase(Purchase purchase) {
        Double value = purchase.getQuantity() * purchase.getPurchase_price();

        logger.info("Valor da conta na compra: {}", purchase.getAccount());

        accountService.updateBalance(purchase.getAccount(), value);
        purchaseRepository.save(purchase);
    }

}
