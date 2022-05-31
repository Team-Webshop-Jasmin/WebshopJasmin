package at.jasminsweets.admin.persistence.model;

import lombok.Data;
@Data
public class ProductModel {

    private Integer id;

    private String title;

    private double price;

    private String shortDescription;

    private String longDescription;
}
