/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;


import com.bootcamp.entity.IndicateurQuantitatif;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class IndicateurQuantitatifRepository {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create( IndicateurQuantitatif indicateurQuantitatif) {
         em.getTransaction().begin();
        em.persist(indicateurQuantitatif);
        em.getTransaction().commit();
    }

    public void delete( IndicateurQuantitatif indicateurQuantitatif) {
        em.getTransaction().begin();
        em.remove(indicateurQuantitatif);
        em.getTransaction().commit();
    }

    public  IndicateurQuantitatif find(Long indicateurQuantitatif_id) {
         IndicateurQuantitatif result;
        em.getTransaction().begin();
        result = em.find( IndicateurQuantitatif.class, indicateurQuantitatif_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(IndicateurQuantitatif indicateurQuantitatif) {
        em.getTransaction().begin();
        em.refresh(indicateurQuantitatif);
        em.getTransaction().commit();
    }
    
    
}
