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
import org.forit.blog.dao.CategoriaDAO;
import org.forit.blog.dto.CategoriaDTO;

/**
 *
 * @author UTENTE
 */
@Path("/categoria")
public class CategoriaRest {
    
    @Path("/{id}")
    @GET
    @Produces("application/json")
    public CategoriaDTO getCategoria(@PathParam(value = "id")long id){
        CategoriaDAO manager=new CategoriaDAO();
        return manager.getCategoria(id);
    }
    
    @Path("/")
    @GET
    @Produces("application/json")
    public List<CategoriaDTO> getCategorie(){
        CategoriaDAO manager=new CategoriaDAO();
        return manager.getCategorie();
    }
    
    @Path("/")
    @POST
    @Produces("application/json")
    public boolean insertCategoria(CategoriaDTO categoria){
        CategoriaDAO manager=new CategoriaDAO();
        return manager.insertCategoria(-1, categoria);
    }
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public boolean updateCategoria(@PathParam(value = "id")long id, CategoriaDTO categoria){
        CategoriaDAO manager=new CategoriaDAO();
        return manager.insertCategoria(id, categoria);
    }
    
    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    public boolean deleteCategoria(@PathParam(value = "id")long id){
        CategoriaDAO manager=new CategoriaDAO();
        return manager.deleteCategoria(id);
    }
}
