/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.forit.blog.dto.PostDTO;
import org.forit.blog.entity.EntityManagerProvider;
import org.forit.blog.entity.PostEntity;
import org.forit.blog.entity.QPostEntity;

/**
 *
 * @author UTENTE
 */
public class PostDAO {

    public PostDTO getPost(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QPostEntity qpe = QPostEntity.postEntity;
        JPAQueryFactory queryJPA = new JPAQueryFactory(em);
        PostEntity postEntity = queryJPA.selectFrom(qpe).where(qpe.id.eq(id)).fetchOne();
        em.close();
        return new PostDTO(postEntity.getId(),
                postEntity.getIdCategoria(),
                postEntity.getIdAutore(),
                postEntity.getTitolo(),
                postEntity.getDescrizione(),
                postEntity.getData(),
                postEntity.getVisite(),
                postEntity.isVisibile());
    }

    public List<PostDTO> getPosts() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QPostEntity qpe = QPostEntity.postEntity;
        JPAQueryFactory queryJPA = new JPAQueryFactory(em);
        List<PostEntity> postEntity = queryJPA.selectFrom(qpe).fetch();
        List<PostDTO> listaPost = postEntity.stream().map(entity -> {
            PostDTO post = new PostDTO(entity.getId(),
                    entity.getIdCategoria(),
                    entity.getIdAutore(),
                    entity.getTitolo(),
                    entity.getDescrizione(),
                    entity.getData(),
                    entity.getVisite(),
                    entity.isVisibile());
            return post;
        }).collect(Collectors.toList());
        em.close();
        return listaPost;
    }

    public boolean insertPost(long id, PostDTO post) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        PostEntity postEntity = new PostEntity(post.getIdCategoria(),
                post.getTitolo(),
                post.getDescrizione(),
                post.getIdAutore(),
                post.getData(),
                post.getVisite(),
                post.isVisibile());
        if(id!=(long)-1){
            postEntity.setId(id);
        }
        try {
            em.getTransaction().begin();
            if (id != -1) {
                em.merge(postEntity);
            } else {
                em.persist(postEntity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ERRORE: " + ex);
            em.getTransaction().rollback();
            return false;
        }
        em.close();
        return true;
    }

    public boolean deletePost(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QPostEntity qpe = QPostEntity.postEntity;
        JPAQueryFactory queryJPA = new JPAQueryFactory(em);
        PostEntity postEntity = queryJPA.selectFrom(qpe).where(qpe.id.eq(id)).fetchOne();
        try {
            em.getTransaction().begin();
            em.remove(postEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("ERRORE: " + ex);
            return false;
        }
        em.close();
        return true;
    }

}
