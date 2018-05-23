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
import org.forit.blog.dto.TagDTO;
import org.forit.blog.entity.EntityManagerProvider;
import org.forit.blog.entity.QTagEntity;
import org.forit.blog.entity.TagEntity;

/**
 *
 * @author UTENTE
 */
public class TagDAO {

    public TagDTO getTag(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QTagEntity qte = QTagEntity.tagEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        TagEntity tagEntity = query.selectFrom(qte).where(qte.id.eq(id)).fetchOne();
        em.close();
        return new TagDTO(tagEntity.getId(), tagEntity.getNome());
    }

    public List<TagDTO> getTags() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QTagEntity qte = QTagEntity.tagEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        List<TagEntity> listaEntity = query.selectFrom(qte).fetch();
        List<TagDTO> listaTag = listaEntity.stream().map(
                entity -> {
                    TagDTO tag = new TagDTO(entity.getId(), entity.getNome());
                    return tag;
                }
        ).collect(Collectors.toList());
        em.close();
        return listaTag;
    }

    public boolean insertTag(long id, TagDTO tag) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        TagEntity tagEntity = new TagEntity(tag.getNome());
        if(id!=(long)-1){
            tagEntity.setId(id);
        }
        try {
            em.getTransaction().begin();
            if (id != -1) {
                em.merge(tagEntity);
            } else {
                em.persist(tagEntity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("ERRORE: " + ex);
            return false;
        }
        em.close();
        return true;
    }

    public boolean deleteTag(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QTagEntity qte = QTagEntity.tagEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        TagEntity tagEntity = query.selectFrom(qte).where(qte.id.eq(id)).fetchOne();
        try {
            em.getTransaction().begin();
            em.remove(tagEntity);
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
