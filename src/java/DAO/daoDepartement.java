/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Departement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author elhaddadmohamed
 */
public class daoDepartement {
    EntityManager em;
    EntityTransaction tx;

    public daoDepartement() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Carref_WebPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
    }
     public List<Departement> Tous() {
         
        return em.createNamedQuery("Departement.findAll").getResultList();
    }
    public  List<Departement> findAll() {
        
        Query req = em.createQuery(" select d from Departement d");
        return req.getResultList();
    }
     public void add(Departement E) {
        try {
            tx.begin();
            em.persist(E);
            tx.commit();
            System.out.println("Add executed");
            
            
        } 
        catch (Exception ex) {
            System.err.println("Erreur : " + ex.getMessage());
        }
    }
    
    public void update(Departement E) 
    {
        try{
            tx.begin();
            em.merge(E);
            tx.commit();
            System.out.println("Update executed");
        }catch(Exception ex ){
            System.err.println("Erreur : " + ex.getMessage());
        }
    }
    public Departement FindByCode(String Code)
    {
        
        Departement d = em.find(Departement.class, Code);
        return d ;
    }
    public void DeleteByCode(String Code)
    {
        
        Departement d = em.find(Departement.class, Code);
        if(d!=null)
        {   
            tx.begin();
            em.remove(d);
            tx.commit();
            
            System.out.println(" successful deletion");
        }
        else
             System.err.println(" deletion failed");
            
    }
}
