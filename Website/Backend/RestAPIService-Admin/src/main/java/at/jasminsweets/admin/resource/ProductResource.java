package at.jasminsweets.admin.resource;

import at.jasminsweets.admin.persistence.model.ProductModel;
import at.jasminsweets.admin.service.ProductService;
import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.hibernate.service.spi.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Objects;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private ProductService productService;

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Get All Products",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = ProductModel.class)
            )
    )
    public Response get() {
        return Response.ok(productService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @APIResponse(
            responseCode = "200",
            description = "Get Product by id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = ProductModel.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Product does not exist for Id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getById(@Parameter(name = "id", required = true) @PathParam("id") Integer id) {
        return productService.findById(id)
                .map(product -> Response.ok(product).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @APIResponse(
            responseCode = "201",
            description = "Product Created",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = ProductModel.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid Product",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Product already exists for id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response post(@NotNull ProductModel productModel, @Context UriInfo uriInfo) {
        productService.save(productModel);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(productModel.getId())).build();
        return Response.created(uri).entity(productModel).build();
    }

    @PUT
    @Path("/{id}")
    @APIResponse(
            responseCode = "204",
            description = "Product updated",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = ProductModel.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid Product",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Product object does not have id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Path variable id does not match ProductModel.id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "404",
            description = "No Product found for id provided",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response put(@Parameter(name = "id", required = true) @PathParam("id") Integer id, @NotNull ProductModel productModel) {
        if (!Objects.equals(id, productModel.getId())) {
            throw new ServiceException("Path variable id does not match ProductModel.id");
        }
        productService.update(productModel);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
