package at.jasminsweets.admin.controller;

import at.jasminsweets.admin.domain.AdminLog;
import at.jasminsweets.admin.domain.Product;
import at.jasminsweets.admin.model.AdminLogModel;
import io.smallrye.common.constraint.NotNull;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public class LoginAsAdmin {
    private boolean islogged = false;

    @GET
    public Response getList(){
        List<AdminLog> adminLog = AdminLog.findAll().list();
        return Response.ok(adminLog).build();
    }

    @POST
    @Transactional
    public Response checkLoggin(@NotNull AdminLogModel model){
        AdminLog adminLog = AdminLog.findById(13);
        if (adminLog.emailAdress == model.emailAdress && adminLog.password == model.password){
            islogged = true;
            return Response.ok("Logged in successfully!").build();
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
