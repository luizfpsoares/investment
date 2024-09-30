package br.com.debugsystem.investment.services;

import java.util.List;
import java.util.stream.Collectors;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.AccountSummaryDTO;
import br.com.debugsystem.investment.dtos.PurchaseDTO;
import br.com.debugsystem.investment.entities.Purchase;
import br.com.debugsystem.investment.infra.PurchaseRepository;

@Service
public class PurchaseService {

    //private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private AccountService accountService;

     public List<PurchaseDTO> findAll(){
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PurchaseDTO getById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        return convertToDTO(purchase);
    }

    public void savePurchase(Purchase purchase) {
        Double value = purchase.getQuantity() * purchase.getPurchasePrice();

        //logger.info("Valor da conta na compra: {}", purchase.getAccount());

        accountService.updateBalance(purchase.getAccount(), value, purchase.getOriginAport());
        purchaseRepository.save(purchase);
    }

    private PurchaseDTO convertToDTO(Purchase purchase) {
        //ClientSummaryDTO clientSummary = new ClientSummaryDTO(purchase.getAccount().getClient().getId(), purchase.getAccount().getClient().getName());
        AccountSummaryDTO accountSummary = new AccountSummaryDTO(purchase.getAccount().getId(), purchase.getAccount().getType().toString());

        return new PurchaseDTO(
            purchase.getId(),
            purchase.getdtPurchase(),
            purchase.getPurchasePrice(),
            purchase.getQuantity(),
            purchase.getOriginAport().toString(),
            accountSummary
        );
    }
}
