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
import org.forit.blog.dao.CommentoDAO;
import org.forit.blog.dto.CommentoDTO;

/**
 *
 * @author UTENTE
 */
@Path("/commento")
public class CommentoRest {
    
    @Path("/{id}")
    @GET
    @Produces("application/json")
    public CommentoDTO getCommento(@PathParam(value = "id")long id){
        CommentoDAO manager=new CommentoDAO();
        return manager.getCommento(id);
    }
    
    @Path("/")
    @GET
    @Produces("application/json")
    public List<CommentoDTO> getCommenti(){
        CommentoDAO manager=new CommentoDAO();
        return manager.getCommenti();
    }
    
    @Path("/")
    @POST
    @Produces("application/json")
    public boolean insertCommento(CommentoDTO commento){
        CommentoDAO manager=new CommentoDAO();
        return manager.insertCommento(-1, commento);
    }
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public boolean updateCommento(@PathParam(value = "id")long id, CommentoDTO commento){
        CommentoDAO manager=new CommentoDAO();
        return manager.insertCommento(id, commento);
    }
    
    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    public boolean deleteCommento(@PathParam(value = "id")long id){
        CommentoDAO manager=new CommentoDAO();
        return manager.deleteCommento(id);
    }
}
