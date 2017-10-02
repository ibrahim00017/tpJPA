/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Projet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class ProjetRepository {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
      
    public void create( Projet projet) {
         em.getTransaction().begin();
        em.persist(projet);
        em.getTransaction().commit();
    }

    public void delete( Projet projet) {
        em.getTransaction().begin();
        em.remove(projet);
        em.getTransaction().commit();
    }

    public  Projet find(Long projet_id) {
         Projet result;
        em.getTransaction().begin();
        result = em.find( Projet.class, projet_id);
        em.getTransaction().commit();
        return result;

    }

    public void update(Projet projet) {
        em.getTransaction().begin();
        em.refresh(projet);
        em.getTransaction().commit();
    }
    
}
