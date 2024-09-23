package br.com.debugsystem.investment.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.debugsystem.investment.enums.OriginApportEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String dtPurchase;

    @Column(nullable = false)
    private Double purchasePrice;

    @Column(nullable = false)
    private Long quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OriginApportEnum originAport;

    @ManyToOne
    @JoinColumn(name = "active_id", nullable = false)
    @JsonBackReference
    private Active active;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    
    public Purchase() {
    }

    public Purchase(String dtPurchase, Double purchasePrice, Long quantity, OriginApportEnum originAport, Active active,
            Account account) {
        this.dtPurchase = dtPurchase;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.originAport = originAport;
        this.active = active;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getdtPurchase() {
        return dtPurchase;
    }

    public void setdtPurchase(String dtPurchase) {
        this.dtPurchase = dtPurchase;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public OriginApportEnum getoriginAport() {
        return originAport;
    }

    public void setoriginAport(OriginApportEnum originAport) {
        this.originAport = originAport;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
