/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entities.Departement;
import Entities.Employe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ELHADDAD
 */
public class daoEmploye {
    EntityManager em;
    EntityTransaction tx;
    
    public daoEmploye()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Carref_WebPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    public boolean addEmploye(Employe e)
    {
        
        if(findByCode(e.getIdEmp()) != null)
            return false;
        tx.begin();
        em.persist(e);
        tx.commit();
        return true;
    }
    
    public boolean updateEmploye(Employe e) {
        if(findByCode(e.getIdEmp()) == null)
            return false;
        tx.begin();
        em.merge(e);
        tx.commit();
        return true;
    }

    public boolean deleteEmploye(Employe e) {
        if(findByCode(e.getIdEmp()) == null)
            return false;
        tx.begin();
        em.remove(e);
        tx.commit();
        return true;
    }
    
    public Employe findByCode(String code)
    {
        Employe e = null;
        tx.begin();
        e = em.find(Employe.class, code);
        tx.commit();
    
        return e;
    }
      public List<Employe> findAll() {
        Query req = em.createQuery(" select d from Employe d");
        return req.getResultList();
    }
         public List<Employe> EmpByDept(String code) {
             Departement dept = em.find(Departement.class, code);
             Query req=null ;
             if(dept!=null) 
             {
                req = em.createQuery(" select d from Employe d where d.refDept=:dept");
                 req.setParameter("dept", dept);
        
                return req.getResultList();
             }
             return null;
    }
    public void DeleteByCode(String Code)
    {
        
        Employe d = em.find(Employe.class, Code);
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
