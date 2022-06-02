package at.jasminsweets.admin.model;

import at.jasminsweets.admin.domain.Product;
import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.OneToOne;

public class SnipCartModel {
    //Attribute
    @Schema(example = "Wie viel Gramm?")
    public String sizeSelector;
    @Schema(example = "400g|700g[+6.00]|1000g[+10.00]")
    public String amount;
    //Constructor
    public SnipCartModel() {
    }
}

