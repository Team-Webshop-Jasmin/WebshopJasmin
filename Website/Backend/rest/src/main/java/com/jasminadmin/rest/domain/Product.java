package com.jasminadmin.rest.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    @Column(nullable = true)
    private double beforeprice;
    @Column(nullable = true)
    private String shortDescription;
    private int productID;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String amount;
    private String type;

    //Constructor

    public Product() {
    }

    public Product(String title, double price, double beforeprice, String shortDescription, int productID, String name, String amount, String type) {
        this.title = title;
        this.price = price;
        this.beforeprice = beforeprice;
        this.shortDescription = shortDescription;
        this.productID = productID;
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    //Getter and Setter


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

    public double getBeforeprice() {
        return beforeprice;
    }

    public void setBeforeprice(double beforeprice) {
        this.beforeprice = beforeprice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
