package at.htlleonding.logic;

import at.htlleonding.persistence.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class Service {
    @Inject
    EntityManager em;

    @Transactional
    public void addCustomer(Customer c){em.persist(c);}

    @Transactional
    public void addUser(User u){em.persist(u);}

    @Transactional
    public void addShoppingCart(ShoppingCart sc){em.persist(sc);}

    @Transactional
    public void addShippingAddress(ShippingAddress sa){em.persist(sa);}

    @Transactional
    public void addSalesOrder(SalesOrder so){em.persist(so);}

    @Transactional
    public void addProduct(Product p){em.persist(p);}

    @Transactional
    public void addCartItem(CartItem ci){em.persist(ci);}

    @Transactional
    public void addBillingAddress(BillingAddress ba){em.persist(ba);}

}
