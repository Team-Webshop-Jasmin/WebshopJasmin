package at.jasminsweets.admin.persistence.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = true)
    private String shortDescription;

    @Column(nullable = true)
    private String longDescription;

    @OneToOne
    @JoinColumn(name ="snipCart_Id")
    private SnipCart snipCart;

    public Product(){}

    public Product(String title, double price, String shortDescription, String longDescription) {
        this.title = title;
        this.price = price;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public SnipCart getSnipCart() {
        return snipCart;
    }

    public void setSnipCart(SnipCart snipCart) {
        this.snipCart = snipCart;
    }

}