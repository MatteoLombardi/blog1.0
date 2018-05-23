/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.rest;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.blog.dao.UserDAO;
import org.forit.blog.dto.UserDTO;

/**
 *
 * @author UTENTE
 */
@Path("/user")
public class UserRest {
    @Path("/{id}")
    @GET
    @Produces("application/json")
    public UserDTO getAccount(@PathParam(value = "id")long id){
        UserDAO manager=new UserDAO();
        return manager.getUser(id);
    }
    
    @Path("/")
    @GET
    @Produces("application/json")
    public List<UserDTO> getAccounts(){
        UserDAO manager=new UserDAO();
        return manager.getUsersList();
    }
    
    @Path("/")
    @POST
    @Produces("application/json")
    public boolean insertAccount(UserDTO account){
        UserDAO manager=new UserDAO();
        return manager.insertUser(-1, account);
    }
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public boolean updateAccount(@PathParam(value = "id")long id, UserDTO account){
        UserDAO manager=new UserDAO();
        return manager.insertUser(id, account);
    }
    
    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    public boolean deleteAccount(@PathParam(value = "id")long id){
        UserDAO manager=new UserDAO();
        return manager.deleteUser(id);
    }
}
