/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class NoteUnLieuDAO implements DAO<NoteUnLieuEntity>{
     
    private EntityManager em;

    public NoteUnLieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

   
    @Override
    public List findAll() {
        List<NoteUnLieuEntity> listNoteUnLieu = em.createQuery("Select a FROM NoteUnLieu a").getResultList();
        return listNoteUnLieu;
    }

    @Override
    public void create(NoteUnLieuEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public void update(NoteUnLieuEntity obj) {
        em.getTransaction().begin();
         em.merge(obj);
        em.getTransaction().commit();
        em.close();    }
        @Override
    public void delete(NoteUnLieuEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    
    public NoteUnLieuEntity findById(String id) {
        return em.find(NoteUnLieuEntity.class, id);
    }
}
