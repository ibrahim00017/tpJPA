/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.IndicateurPerformance;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class IndicateurPerformanceRepository {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create( IndicateurPerformance  indicateurPerformance) {
         em.getTransaction().begin();
        em.persist(indicateurPerformance);
        em.getTransaction().commit();
    }

    public void delete( IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.remove(indicateurPerformance);
        em.getTransaction().commit();
    }

    public  IndicateurPerformance find(Long indicateurPerformance_id) {
         IndicateurPerformance result;
        em.getTransaction().begin();
        result = em.find( IndicateurPerformance.class, indicateurPerformance_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.refresh(indicateurPerformance);
        em.getTransaction().commit();
    }
    
}
