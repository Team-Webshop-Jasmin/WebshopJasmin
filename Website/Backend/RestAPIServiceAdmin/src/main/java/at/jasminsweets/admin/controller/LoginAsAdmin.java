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
    @POST
    @Path("{id}")
    @Transactional
    public String checkLoggin(@PathParam("id") Long id, @NotNull AdminLogModel model){
        AdminLog adminLog = AdminLog.findById(id);
        if (adminLog.emailAdress.equals(model.emailAdress) && adminLog.password.equals(model.password)){
            return "Logged in successfully!";
        }
        else{
            throw new WebApplicationException("Email-Adress or Password is incorrect!", 404);
        }
    }
}
