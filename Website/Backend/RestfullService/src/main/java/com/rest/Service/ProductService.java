package com.rest.Service;

import com.rest.Entity.Product;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey="posts")
public interface ProductService {
    @GET
    List<Product> getAll();
}
