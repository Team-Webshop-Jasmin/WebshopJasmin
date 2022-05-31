package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.Repositories.ProductRepository;
import at.jasminsweets.admin.persistence.entities.Product;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }


}
