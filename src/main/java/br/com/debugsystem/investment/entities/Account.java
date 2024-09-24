package br.com.debugsystem.investment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.debugsystem.investment.enums.TypeAccountEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeAccountEnum type;
    
    @Column(nullable = false)
    private Double balance;

    @Column(name = "balance_monthly_apport_only", nullable = false)
    private Double balanceMonthlyApportOnly;
    
    @Column(nullable = false)
    private String dtOpening;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"account", "purchases"})
    @JsonIgnore
    private List<Purchase> purchases;

    public Account() {
    }

    public Account(TypeAccountEnum type, Double balance, Double balanceMonthlyApportOnly, String dtOpening, Client client) {
        this.type = type;
        this.balance = balance;
        this.balanceMonthlyApportOnly = balanceMonthlyApportOnly;
        this.dtOpening = dtOpening;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public TypeAccountEnum getType() {
        return type;
    }

    public void setType(TypeAccountEnum type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalanceMonthlyApportOnly() {
        return balanceMonthlyApportOnly;
    }

    public void setBalanceMonthlyApportOnly(Double balanceMonthlyApportOnly) {
        this.balanceMonthlyApportOnly = balanceMonthlyApportOnly;
    }

    public String getDtOpening() {
        return dtOpening;
    }

    public void setDtOpening(String dtOpening) {
        this.dtOpening = dtOpening;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void updateBalance(Double value) {
        this.balance += value;
    }

    public void updateBalanceMonthlyApportOnly(Double value) {
        this.balanceMonthlyApportOnly += value;
    }


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
  
}
