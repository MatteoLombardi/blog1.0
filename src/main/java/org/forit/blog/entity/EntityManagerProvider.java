/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author UTENTE
 */
public class EntityManagerProvider {
    private static EntityManagerFactory emf;

    public EntityManagerProvider() {
    }

    public static void init() {
        emf = Persistence.createEntityManagerFactory("blog_pu");
    }

    public static void destroy() {
        if (emf != null) {
            emf.close();
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}
