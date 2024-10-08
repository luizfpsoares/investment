package br.com.debugsystem.investment.dtos;

import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.enums.TypeAccountEnum;

public class AccountRequestDTO {
    private Long id;
    private TypeAccountEnum type;
    private Double balance;
    private Double balanceMonthlyApportOnly;
    private Client client;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(Long id, TypeAccountEnum type, Double balance, Double balanceMonthlyApportOnly,
            Client client) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.balanceMonthlyApportOnly = balanceMonthlyApportOnly;
        this.client = client;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    
}
