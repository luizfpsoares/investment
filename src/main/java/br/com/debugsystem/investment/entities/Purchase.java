package br.com.debugsystem.investment.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String dt_purchase;

    @Column(nullable = false)
    private Long purchase_price;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private String origin_aport;

    @ManyToOne
    @JoinColumn(name = "active_id", nullable = false)
    @JsonBackReference
    private Active active;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    
    public Purchase() {
    }

    public Purchase(String dt_purchase, Long purchase_price, Long quantity, String origin_aport, Active active,
            Account account) {
        this.dt_purchase = dt_purchase;
        this.purchase_price = purchase_price;
        this.quantity = quantity;
        this.origin_aport = origin_aport;
        this.active = active;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getDt_purchase() {
        return dt_purchase;
    }

    public void setDt_purchase(String dt_purchase) {
        this.dt_purchase = dt_purchase;
    }

    public Long getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Long purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getOrigin_aport() {
        return origin_aport;
    }

    public void setOrigin_aport(String origin_aport) {
        this.origin_aport = origin_aport;
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
