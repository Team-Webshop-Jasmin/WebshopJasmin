package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.domain.AdminLog;
import at.jasminsweets.admin.model.AdminLogModel;
import io.smallrye.common.constraint.NotNull;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class LoginAsAdmin {
    public boolean islogged = false;

    /*@GET
    @Path("{id}")
    public Response getSingle(@PathParam("id") Long id){
        AdminLog adminLog = AdminLog.findById(id);

        return Response.ok(adminLog).build();
    }*/

    @POST
    @Path("{id}")
    @Transactional
    public String checkLoggin(@PathParam("id") Long id, @NotNull AdminLogModel model){
        AdminLog adminLog = AdminLog.findById(id);
        if (adminLog.emailAdress == model.emailAdress && adminLog.password == model.password){
            islogged = true;
            return "Logged in successfully!";
        }
        else{
            throw new WebApplicationException("Email-Adress or Password is incorrect!", 404);
        }
    }

    public boolean isLoggedIn(){
        boolean result = false;
        if (islogged == true){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
}
