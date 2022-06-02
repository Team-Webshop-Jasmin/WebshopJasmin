package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.domain.Product;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    //Get All Products from Database
    @GET
    public Response getList(){
        List<Product> product = Product.findAll().list();
        return Response.ok(product).build();
    }

    @POST
    public Response save(){

    }
}
