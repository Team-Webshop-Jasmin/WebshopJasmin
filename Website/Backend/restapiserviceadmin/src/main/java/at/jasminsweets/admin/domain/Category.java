package at.jasminsweets.admin.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends PanacheEntity {
    //Atribute
    public String title;
    public String desc;
    @OneToMany(mappedBy = "category")
    public List<Product> products = new ArrayList<Product>();

    //Constructor
    public Category(){}
    public Category(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    //Getter and Setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
