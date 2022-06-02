package at.jasminsweets.admin.model;

import at.jasminsweets.admin.domain.SnipCart;
import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
    @Schema(example = "Schmeckt gut, weil es aus Honig besteht")
    public String longDescription;

    //Constructor
    public ProductModel(){}
}
