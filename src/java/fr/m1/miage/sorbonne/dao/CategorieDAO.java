/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class CategorieDAO implements DAO<CategorieEntity> {
    
    private EntityManager em;

    public CategorieDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

   
    @Override
    public List findAll() {
        List<CategorieEntity> listCategorie = em.createQuery("Select c FROM CategorieEntity  c").getResultList();
        return listCategorie;
    }

    @Override
    public void create(CategorieEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public void update(CategorieEntity obj) {
        em.getTransaction().begin();
         em.merge(obj);
        em.getTransaction().commit();
        em.close();    }
    @Override
    public void delete(CategorieEntity obj) {
        em.getTransaction().begin();
         obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    
    public CategorieEntity findById(String id) {
        
        System.out.println("lib" +em.find(CategorieEntity.class, id).getLibelle());
        return em.find(CategorieEntity.class, id);
    }
}
