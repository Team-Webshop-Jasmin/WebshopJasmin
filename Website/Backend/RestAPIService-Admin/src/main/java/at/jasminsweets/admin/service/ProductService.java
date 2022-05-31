package at.jasminsweets.admin.service;

import at.jasminsweets.admin.persistence.entities.Product;
import at.jasminsweets.admin.persistence.repo.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.customerMapper.toDomainList(productRepository.findAll().list());
    }
}
