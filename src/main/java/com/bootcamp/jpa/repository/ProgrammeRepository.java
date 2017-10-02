/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Programme;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class ProgrammeRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create(Programme programme) {
         em.getTransaction().begin();
        em.persist(programme);
        em.getTransaction().commit();
    }

    public void delete(Programme programme) {
        em.getTransaction().begin();
        em.remove(programme);
        em.getTransaction().commit();
    }

    public Programme find(Long programme_id) {
        Programme result;
        em.getTransaction().begin();
        result = em.find(Programme.class, programme_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(Programme programme) {
        em.getTransaction().begin();
        em.refresh(programme);
        em.getTransaction().commit();
    }

}
