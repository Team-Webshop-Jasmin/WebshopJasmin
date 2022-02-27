package at.htlleonding.persistence;

import org.graalvm.nativeimage.c.struct.CPointerTo;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String emailAddress;

    @Column
    private String password;
}
