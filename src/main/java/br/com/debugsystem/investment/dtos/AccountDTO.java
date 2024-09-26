package br.com.debugsystem.investment.dtos;

public class AccountDTO {
    private Long id;
    private String type;
    private Double balance;
    private Double balanceMonthlyApportOnly;
    private String dtOpening;
    private ClientSummaryDTO client;
    
    public AccountDTO() {
    }

    public AccountDTO(Long id, String type, Double balance, Double balanceMonthlyApportOnly, String dtOpening,
            ClientSummaryDTO client) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.balanceMonthlyApportOnly = balanceMonthlyApportOnly;
        this.dtOpening = dtOpening;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ClientSummaryDTO getClientId() {
        return client;
    }

    public void setClientId(ClientSummaryDTO clientId) {
        this.client = clientId;
    }

}
