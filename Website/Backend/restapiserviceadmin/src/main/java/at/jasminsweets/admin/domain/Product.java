package at.jasminsweets.admin.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
public class Product extends PanacheEntity {
    //Attribute
    @NotNull
    public String title;
    @NotNull
    public String price;
    public String shortDescription;
    public String longDescription;
    public String sizeSelector;
    public String amount;


    //Constructor
    public Product(){}

    public Product(String title, String price, String shortDescription, String longDescription, String sizeSelector, String amount) {
        this.title = title;
        this.price = price;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.sizeSelector = sizeSelector;
        this.amount = amount;
    }

    //Getter and Setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
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
}
