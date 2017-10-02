/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.IndicateurQuantitatif;
import com.bootcamp.entity.Livrable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class LivrableRepository {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create( Livrable livrable) {
         em.getTransaction().begin();
        em.persist(livrable);
        em.getTransaction().commit();
    }

    public void delete( Livrable livrable) {
        em.getTransaction().begin();
        em.remove(livrable);
        em.getTransaction().commit();
    }

    public  Livrable find(Long livrable_id) {
         Livrable result;
        em.getTransaction().begin();
        result = em.find( Livrable.class, livrable_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(Livrable livrable) {
        em.getTransaction().begin();
        em.refresh(livrable);
        em.getTransaction().commit();
    }
    
}
