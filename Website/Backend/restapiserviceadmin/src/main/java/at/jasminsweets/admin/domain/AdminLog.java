package at.jasminsweets.admin.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.Entity;

@Entity
public class AdminLog extends PanacheEntity {
    //Attribute
    @NotNull
    public String emailAdress;

    @NotNull
    public String password;

    //Constructor
    public AdminLog(){}

    public AdminLog(String emailAdress, String password) {
        this.emailAdress = emailAdress;
        this.password = password;
    }

    //Getter and Setter

    public String getEmailAdress() {
        return emailAdress;
    }
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
