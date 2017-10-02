/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.IndicateurQualitatif;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class IndicateurQualitatifRepository {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create( IndicateurQualitatif indicateurQualitatif) {
         em.getTransaction().begin();
        em.persist(indicateurQualitatif);
        em.getTransaction().commit();
    }

    public void delete( IndicateurQualitatif indicateurQualitatif) {
        em.getTransaction().begin();
        em.remove(indicateurQualitatif);
        em.getTransaction().commit();
    }

    public  IndicateurQualitatif find(Long indicateurQualitatif_id) {
         IndicateurQualitatif result;
        em.getTransaction().begin();
        result = em.find( IndicateurQualitatif.class, indicateurQualitatif_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(IndicateurQualitatif indicateurQualitatif) {
        em.getTransaction().begin();
        em.refresh(indicateurQualitatif);
        em.getTransaction().commit();
    }
    
    
}
