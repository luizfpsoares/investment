package br.com.debugsystem.investment.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private Double balance;
    
    @Column(nullable = false)
    private String dt_opening;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    //@JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "account", targetEntity = Purchase.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<Purchase> purchases;

    public Account() {
    }

    public Account(String type, Double balance, String dt_opening, Client client) {
        this.type = type;
        this.balance = balance;
        this.dt_opening = dt_opening;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getDt_opening() {
        return dt_opening;
    }

    public void setDt_opening(String dt_opening) {
        this.dt_opening = dt_opening;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void updateBalance(Long value) {
        this.balance += value;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

  
}
