package at.htlleonding.logic;

import at.htlleonding.persistence.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class Logic {

    @Inject
    Service s;

    @Transactional
    public void createCustomer(String firstName, String lastName) {
        var c = new Customer(firstName, lastName);
        s.addCustomer(c);
    }

}
