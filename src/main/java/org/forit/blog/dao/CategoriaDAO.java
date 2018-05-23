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
import org.forit.blog.dto.CategoriaDTO;
import org.forit.blog.entity.CategoriaEntity;
import org.forit.blog.entity.EntityManagerProvider;
import org.forit.blog.entity.QCategoriaEntity;

/**
 *
 * @author UTENTE
 */
public class CategoriaDAO {
    
    public CategoriaDTO getCategoria(long id){
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCategoriaEntity qce = QCategoriaEntity.categoriaEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        CategoriaEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
        em.close();
        return new CategoriaDTO(entity.getId(),
                    entity.getNome(),
                    entity.getDescrizione(),
                    entity.getImmagine(),
                    entity.isVisibile());
    }
    
    public List<CategoriaDTO> getCategorie() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCategoriaEntity qce = QCategoriaEntity.categoriaEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        List<CategoriaEntity> listaEntity = query.selectFrom(qce).fetch();
        List<CategoriaDTO> listaCategorie = listaEntity.stream().map(entity -> {
            return new CategoriaDTO(entity.getId(),
                    entity.getNome(),
                    entity.getDescrizione(),
                    entity.getImmagine(),
                    entity.isVisibile());
        }).collect(Collectors.toList());
        em.close();
        return listaCategorie;
    }
    
    public boolean insertCategoria(long id,CategoriaDTO categoria){
        EntityManager em = EntityManagerProvider.getEntityManager();
        CategoriaEntity entity=new CategoriaEntity(categoria.getNome(), categoria.getDescrizione(), categoria.getImmagine(), categoria.isVisibile());
        if(id!=(long)-1){
            entity.setId(id);
        }
        try{
            em.getTransaction().begin();
            if(id!=-1){
                em.merge(entity);
            }else{
                em.persist(entity);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("ERRORE: "+ex);
            return false;
        }
        return true;
    }
    
    public boolean deleteCategoria(long id){
        EntityManager em = EntityManagerProvider.getEntityManager();
        QCategoriaEntity qce = QCategoriaEntity.categoriaEntity;
        JPAQueryFactory query = new JPAQueryFactory(em);
        CategoriaEntity entity = query.selectFrom(qce).where(qce.id.eq(id)).fetchOne();
        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("ERRORE: "+ex);
            return false;
        }
        em.close();
        return true;
    }
}
