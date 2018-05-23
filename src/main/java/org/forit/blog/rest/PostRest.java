/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.blog.dao.PostDAO;
import org.forit.blog.dto.PostDTO;

/**
 *
 * @author UTENTE
 */
@Path("/post")
public class PostRest {

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public PostDTO getPost(@PathParam(value = "id") long id) {
        PostDAO manager = new PostDAO();
        return manager.getPost(id);
    }

    @Path("/")
    @GET
    @Produces("application/json")
    public List<PostDTO> getPosts() {
        PostDAO manager = new PostDAO();
        return manager.getPosts();
    }

    @Path("/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public boolean insertPost(@PathParam(value = "id") long id, PostDTO post) {
        PostDAO manager = new PostDAO();
        return manager.insertPost(-1, post);
    }
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public boolean updatePost(@PathParam(value = "id") long id, PostDTO post){
        PostDAO manager=new PostDAO();
        return manager.insertPost(id, post);
    }
    
    @Path("/{id}")
    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    public boolean deletePost(@PathParam(value = "id") long id){
        PostDAO manager=new PostDAO();
        return manager.deletePost(id);
    }

}
