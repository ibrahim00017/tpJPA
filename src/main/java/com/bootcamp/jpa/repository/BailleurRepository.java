/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class BailleurRepository {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
 
    
    public void create(Bailleur bailleur){
     //   Bailleur bailleur = new Bailleur(nom);
        em.getTransaction().begin();
        em.persist(bailleur);
        em.getTransaction().commit();
        System.out.println("le bailleur "+ bailleur.getNom()+" a ete bien a la base");
    }
    
    public void delete(Bailleur bailleur){
         em.getTransaction().begin();
        em.remove(bailleur);
        em.getTransaction().commit();
    }
    
    public Bailleur find(Long bailleur_id){
        Bailleur result ;
         em.getTransaction().begin();
        result=em.find(Bailleur.class, bailleur_id);
        em.getTransaction().commit();
        return result;
        
    }
    
    public void update(Bailleur bailleur){
         em.getTransaction().begin();
        em.refresh(bailleur);
        em.getTransaction().commit();
    }
    
}
