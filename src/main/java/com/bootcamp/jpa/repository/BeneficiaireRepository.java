/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Beneficiaire;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class BeneficiaireRepository {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnit1");
    EntityManager em = emf.createEntityManager();
 
    
    public void create(String nom){
        Beneficiaire beneficiaire = new Beneficiaire(nom);
        em.getTransaction().begin();
        em.persist(beneficiaire);
        em.getTransaction().commit();
    }
    
    public void delete(Beneficiaire beneficiaire){
         em.getTransaction().begin();
        em.remove(beneficiaire);
        em.getTransaction().commit();
    }
    
    public Beneficiaire find(Long beneficiaire_id){
        Beneficiaire result ;
         em.getTransaction().begin();
        result=em.find(Beneficiaire.class, beneficiaire_id);
        em.getTransaction().commit();
        return result;
        
    }
    
    public void update(Beneficiaire beneficiaire){
         em.getTransaction().begin();
        em.refresh(beneficiaire);
        em.getTransaction().commit();
    }
    
}
