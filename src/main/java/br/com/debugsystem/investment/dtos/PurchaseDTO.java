package br.com.debugsystem.investment.dtos;

public class PurchaseDTO {
    private Long id;
    private String dtPurchase;
    private Double purchasePrice;
    private Double quantity;
    private String originApport;
    private AccountSummaryDTO account;

    public PurchaseDTO() {
    }
    
    public PurchaseDTO(Long id, String dtPurchase, Double purchasePrice, Double quantity, String originApport,
            AccountSummaryDTO account) {
        this.id = id;
        this.dtPurchase = dtPurchase;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.originApport = originApport;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDtPurchase() {
        return dtPurchase;
    }

    public void setDtPurchase(String dtPurchase) {
        this.dtPurchase = dtPurchase;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getOriginApport() {
        return originApport;
    }

    public void setOriginApport(String originApport) {
        this.originApport = originApport;
    }

    public AccountSummaryDTO getAccount() {
        return account;
    }

    public void setAccount(AccountSummaryDTO account) {
        this.account = account;
    }

}
