/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class CommentaireLieuDAO implements DAO<CommentaireLieuEntity>{
     
    private EntityManager em;

    public CommentaireLieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(CommentaireLieuEntity obj) {
         em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();     }

    @Override
    public CommentaireLieuEntity findById(String id) {
        return em.find(CommentaireLieuEntity.class, id);
    }

    @Override
    public void update(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();     }

    @Override
    public void delete(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public List<CommentaireLieuEntity> findAll() {
        List<CommentaireLieuEntity> listPCommentaireLieuEntity = em.createQuery("Select a FROM CommentaireLieuEntity a").getResultList();
        return listPCommentaireLieuEntity;   
    }
}
