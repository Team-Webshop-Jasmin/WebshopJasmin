package at.htlleonding.persistence;

import org.graalvm.nativeimage.c.function.CLibrary;

import javax.persistence.*;

@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String  postalCode;

    @Column
    private String country;
}
