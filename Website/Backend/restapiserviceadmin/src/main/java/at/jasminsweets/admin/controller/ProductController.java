package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.domain.Product;
import at.jasminsweets.admin.model.ProductModel;
import io.smallrye.common.constraint.NotNull;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
    //Get All Products from Database
    @GET
    public Response getList(){
        LoginAsAdmin loginAsAdmin = new LoginAsAdmin();
        if (loginAsAdmin.isLoggedIn() == true){
            List<Product> product = Product.findAll().list();

            return Response.ok(product).build();
        }
        else{
            throw new WebApplicationException("You must Login as a Admin", 404);
        }
    }

    //Get Product by ID
    @GET
    @Path("{id}")
    public Response getSingle(@PathParam("id") Long id){
        Product product = Product.findById(id);

        return Response.ok(product).build();
    }

    //Add new Product
    @POST
    @Transactional
    public Response save(@NotNull ProductModel model){
        Product product = new Product(model.title, model.price, model.shortDescription, model.longDescription, model.sizeSelector, model.amount);
        product.persist();

        return Response.ok(product).build();
    }

    //Edit a Product by ID
    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, @NotNull ProductModel model){
        Product product = Product.findById(id);
        if(product == null){
            throw new WebApplicationException("Product with this Id does not exist!", 404);
        }
        product.title = model.title;
        product.price = model.price;
        product.shortDescription = model.shortDescription;
        product.longDescription = model.longDescription;
        product.sizeSelector = model.sizeSelector;
        product.amount = model.amount;
        product.persist();

        return Response.ok(product).build();
    }

    //Delete Product by ID
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id){
        Product product = Product.findById(id);
        if(product == null){
            throw new WebApplicationException("Product with this Id does not exist!", 404);
        }
        product.delete();

        return Response.ok("Deleted successfully!").build();
    }
}
