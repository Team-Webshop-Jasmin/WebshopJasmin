package at.htlleonding.persistence;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @ManyToOne()
    private BillingAddress billingAddress;

    @ManyToOne()
    private ShippingAddress shippingAddress;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber, String billingAddress, String shippingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
