package at.jasminsweets.admin.model;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;

public class ProductModel {
    //Attribute
    @NotNull
    @Schema(required = true, example = "Baklava")
    public String title;
    @NotNull
    @Schema(required = true, example = "15.00")
    public String price;
    @Schema(example = "Schmeckt gut")
    public String shortDescription;
    @Column(length = 1000000)
    @Schema(example = "Schmeckt gut, weil es aus Honig besteht")
    public String longDescription;
    @Schema(example = "Wie viel Gramm?")
    public String sizeSelector;
    @Schema(example = "400g|700g[+6.00]|1000g[+10.00]")
    public String amount;

    //Constructor
    public ProductModel(){}
}
