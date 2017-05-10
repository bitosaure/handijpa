/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.AvisEntity;
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
    public List<CategorieEntity> findAll() {
        
        List<CategorieEntity> listCategorie = em.createQuery("Select entity FROM CategorieEntity as entity").getResultList();
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
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public CategorieEntity findById(int id) {
        return em.find(CategorieEntity.class, id);
    }
}
