package at.jasminsweets.admin.model;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AdminLogModel {
    //Attribute
    @NotNull
    @Schema(required = true, example = "Email-Adress")
    public String emailAdress;

    @NotNull
    @Schema(required = true, example = "Password")
    public String password;

    //Constructor
    public AdminLogModel(){}
}
