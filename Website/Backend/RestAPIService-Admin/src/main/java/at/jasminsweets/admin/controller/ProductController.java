package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.Repositories.FruitRepository;
import at.jasminsweets.admin.Repositories.ProductRepository;
import at.jasminsweets.admin.persistence.entities.Product;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    private final ProductRepository productRepository;

    @GET
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
