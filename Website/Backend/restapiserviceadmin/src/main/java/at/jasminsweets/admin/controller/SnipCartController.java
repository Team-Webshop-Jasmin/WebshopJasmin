package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.domain.Product;
import at.jasminsweets.admin.domain.SnipCart;
import at.jasminsweets.admin.model.ProductModel;
import at.jasminsweets.admin.model.SnipCartModel;
import io.smallrye.common.constraint.NotNull;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/snipCart")
@Produces(MediaType.APPLICATION_JSON)
public class SnipCartController {
    //Get all SnipCart Attribute
    @GET
    public Response getList(){
        List<SnipCart> snipCart = SnipCart.findAll().list();

        return Response.ok(snipCart).build();
    }

    //Get SnipCart Attribute by ID
    @GET
    @Path("{id}")
    public Response getSingle(@PathParam("id") Long id){
        SnipCart snipCart = SnipCart.findById(id);

        return Response.ok(snipCart).build();
    }

    //Add new SnipCart Attribute
    @POST
    @Transactional
    public Response save(@NotNull SnipCartModel model){
        SnipCart snipCart = new SnipCart(model.sizeSelector, model.amount);
        snipCart.persist();

        return Response.ok(snipCart).build();
    }

    //Edit a SnipCart Attribute by ID
    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, @NotNull SnipCartModel model){
        SnipCart snipCart = SnipCart.findById(id);

        if(snipCart == null){
            throw new WebApplicationException("SnipCart with this Id does not exist!", 404);
        }
        snipCart.sizeSelector = model.sizeSelector;
        snipCart.amount = model.amount;
        snipCart.persist();

        return Response.ok(snipCart).build();
    }

    //Delete SnipCart Attribute by ID
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id){
        SnipCart snipCart = SnipCart.findById(id);
        if(snipCart == null){
            throw new WebApplicationException("SnipCart with this Id does not exist!", 404);
        }
        snipCart.delete();
        return Response.ok("Deleted successfully!").build();
    }
}
