/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class CritereDAO implements DAO<CritereEntity>{
     
    private EntityManager em;

    public CritereDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(CritereEntity obj) {
         em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();     }

    @Override
    public CritereEntity findById(String id) {
        return em.find(CritereEntity.class, id);
    }

    @Override
    public void update(CritereEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.close();     }

    @Override
    public void delete(CritereEntity obj) {
        em.getTransaction().begin();
                 obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public List<CritereEntity> findAll() {
        List<CritereEntity> listCritereEntity= em.createQuery("Select a FROM CritereEntity a").getResultList();
        return listCritereEntity;   
    }
    
}
