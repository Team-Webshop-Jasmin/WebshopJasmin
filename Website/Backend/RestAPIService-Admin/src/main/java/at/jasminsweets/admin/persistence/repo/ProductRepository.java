package at.jasminsweets.admin.persistence.repo;

import at.jasminsweets.admin.persistence.entities.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product, Integer> {

}
