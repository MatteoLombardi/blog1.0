/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.forit.blog.dto.UserDTO;
import org.forit.blog.entity.UserEntity;
import org.forit.blog.entity.EntityManagerProvider;
import org.forit.blog.entity.QUserEntity;

/**
 *
 * @author UTENTE
 */
public class UserDAO {

    public UserDTO getUser(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QUserEntity qce = QUserEntity.userEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        UserEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
        em.close();
        return new UserDTO(entity.getId(),
                entity.getIdRuolo(),
                entity.getNumeroTentativi(),
                entity.getNome(),
                entity.getCognome(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.isAttivo(),
                entity.isBloccato(),
                entity.getDataIscrizione(),
                entity.getDataUltimoAccesso());
    }

    public List<UserDTO> getUsersList() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QUserEntity qce = QUserEntity.userEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        List<UserEntity> listaEntity = query.selectFrom(qce).fetch();
        List<UserDTO> listaCategorie = listaEntity.stream().map(entity -> {
            return new UserDTO(entity.getId(),
                    entity.getIdRuolo(),
                    entity.getNumeroTentativi(),
                    entity.getNome(),
                    entity.getCognome(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getPassword(),
                    entity.isAttivo(),
                    entity.isBloccato(),
                    entity.getDataIscrizione(),
                    entity.getDataUltimoAccesso());
        }).collect(Collectors.toList());
        em.close();
        return listaCategorie;
    }

    public boolean insertUser(long id, UserDTO user) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        UserEntity entity = new UserEntity(user.getIdRuolo(),
                user.getNumeroTentativi(),
                user.getNome(),
                user.getCognome(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.isAttivo(),
                user.isBloccato(),
                user.getDataIscrizione(),
                user.getDataUltimoAccesso());
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

    public boolean deleteUser(long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QUserEntity qce = QUserEntity.userEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        UserEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
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
