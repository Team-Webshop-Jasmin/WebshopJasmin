package at.jasminsweets.admin.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SnipCart extends PanacheEntity {
    //Attribute
    public String sizeSelector;
    public String amount;
    @OneToOne(mappedBy = "snipCart")
    public Product product;

    //Constructor
    public SnipCart(){}
    public SnipCart(String sizeSelector, String amount) {
        this.sizeSelector = sizeSelector;
        this.amount = amount;
    }

    //Getter and Setter
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
