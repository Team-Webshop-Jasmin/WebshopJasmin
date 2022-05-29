package com.rest.Controller;

import com.rest.Entity.Product;
import com.rest.Service.ProductService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductController {
    @RestClient
    ProductService service;

    @GET
    @Path("/")
    public Response viewHomePage() {
        List<Product> listproduct = service.getAll();
        return Response.ok(listproduct).build();
    }
}
