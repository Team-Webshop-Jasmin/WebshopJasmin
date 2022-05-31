package at.jasminsweets.admin.persistence.entities;

import javax.persistence.*;

@Entity
public class SnipCart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String sizeSelector;

    @Column(nullable = true)
    private String amount;

    @OneToOne(mappedBy = "snipCart")
    private Product product;

    public SnipCart(){}

    public SnipCart(String sizeSelector, String amount) {
        this.sizeSelector = sizeSelector;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSizeSelector() {
        return sizeSelector;
    }
    public void setSizeSelector(String sizeSelector) {
        this.sizeSelector = sizeSelector;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}

