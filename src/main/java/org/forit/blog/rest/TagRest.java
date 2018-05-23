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
import org.forit.blog.dao.TagDAO;
import org.forit.blog.dto.TagDTO;

/**
 *
 * @author UTENTE
 */
@Path("/tag")
public class TagRest {
    
    @Path("/")
    @GET()
    @Produces("application/json")
    public List<TagDTO> getTags(){
        TagDAO manager=new TagDAO();
        return manager.getTags();
    }
    
    @Path("/{id}")
    @GET
    @Produces("application/json")
    public TagDTO getTag(@PathParam(value = "id") long id){
        TagDAO manager=new TagDAO();
        return manager.getTag(id);
    }
    
    @Path("/")
    @POST
    @Produces("application/json")
    public boolean insertTag(TagDTO tag){
        TagDAO manager=new TagDAO();
        return manager.insertTag(-1,tag);
    }
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public boolean updateTag(@PathParam(value = "id") long id,TagDTO tag){
        TagDAO manager=new TagDAO();
        return manager.insertTag(id, tag);
    }
    
    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    public boolean deleteTag(@PathParam(value = "id") long id){
        TagDAO manager=new TagDAO();
        return manager.deleteTag(id);
    }
    
}
