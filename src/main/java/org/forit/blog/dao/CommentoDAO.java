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
import org.forit.blog.dto.CommentoDTO;
import org.forit.blog.entity.CommentoEntity;
import org.forit.blog.entity.EntityManagerProvider;
import org.forit.blog.entity.QCommentoEntity;

/**
 *
 * @author UTENTE
 */
public class CommentoDAO {

    public CommentoDTO getCommento(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCommentoEntity qce = QCommentoEntity.commentoEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        CommentoEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
        em.close();
        return new CommentoDTO(entity.getId(),
                entity.getIdPost(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getTesto(),
                entity.getRisposta(),
                entity.getDataInserimento(),
                entity.getDataRisposta(),
                entity.isVisibile());
    }

    public List<CommentoDTO> getCommenti() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCommentoEntity qce = QCommentoEntity.commentoEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        List<CommentoEntity> listaEntity = query.selectFrom(qce).fetch();
        List<CommentoDTO> listaCategorie = listaEntity.stream().map(entity -> {
            return new CommentoDTO(entity.getId(),
                    entity.getIdPost(),
                    entity.getNickname(),
                    entity.getEmail(),
                    entity.getTesto(),
                    entity.getRisposta(),
                    entity.getDataInserimento(),
                    entity.getDataRisposta(),
                    entity.isVisibile());
        }).collect(Collectors.toList());
        em.close();
        return listaCategorie;
    }

    public boolean insertCommento(long id, CommentoDTO commento) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        CommentoEntity entity = new CommentoEntity(commento.getIdPost(),
                 commento.getNickname(),
                 commento.getEmail(),
                 commento.getTesto(),
                 commento.getRisposta(),
                 commento.getDataInserimento(),
                 commento.getDataRisposta(),
                 commento.isVisibile());
        if(id!=(long)-1){
            entity.setId(id);
        }
        try {
            em.getTransaction().begin();
            if (id != -1) {
                em.merge(entity);
            } else {
                em.persist(entity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("ERRORE: " + ex);
            return false;
        }
        return true;
    }

    public boolean deleteCommento(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCommentoEntity qce = QCommentoEntity.commentoEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        CommentoEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
        try {
            em.getTransaction().begin();
            em.remove(entity);
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
