package at.jasminsweets.admin.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import javax.persistence.Entity;

@Entity
public class Product extends PanacheEntity {
    //Attribute
    @NotNull
    public String title;
    @NotNull
    public String price;
    public String shortDescription;
    public String longDescription;

    //Constructor
    public Product(){}

    public Product(String title, String price, String shortDescription, String longDescription) {
        this.title = title;
        this.price = price;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }
}
