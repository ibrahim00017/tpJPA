/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Fournisseur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class FournisseurRepository {
     EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
 
    
    public void create(String nom){
        Fournisseur fournisseur = new Fournisseur(nom);
        em.getTransaction().begin();
        em.persist(fournisseur);
        em.getTransaction().commit();
    }
    
    public void delete(Fournisseur fournisseur){
         em.getTransaction().begin();
        em.remove(fournisseur);
        em.getTransaction().commit();
    }
    
    public Fournisseur find(Long fournisseur_id){
        Fournisseur result ;
         em.getTransaction().begin();
        result=em.find(Fournisseur.class, fournisseur_id);
        em.getTransaction().commit();
        return result;
        
    }
    
    public void update(Fournisseur fournisseur){
         em.getTransaction().begin();
        em.refresh(fournisseur);
        em.getTransaction().commit();
    }
}
