package br.com.debugsystem.investment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.debugsystem.investment.enums.TypeAccountEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_actives")
public class Active {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private TypeAccountEnum accountType;

    @OneToMany(mappedBy = "active", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Purchase> purchases;
    
    public Active() {
    }

    public Active(String name, String code, TypeAccountEnum accountType) {
        this.name = name;
        this.code = code;
        this.accountType = accountType;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public TypeAccountEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(TypeAccountEnum accountType) {
        this.accountType = accountType;
    }

    public List<Purchase> getPurchase() {
        return purchases;
    }


    public void setPurchase(List<Purchase> purchase) {
        this.purchases = purchase;
    }
    
}