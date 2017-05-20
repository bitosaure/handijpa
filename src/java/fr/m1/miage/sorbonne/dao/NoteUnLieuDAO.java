/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        em.close();   
    }
        @Override
    public void delete(NoteUnLieuEntity obj) {
        obj=this.findById(obj.getId());
        em.getTransaction().begin();
        em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    
    public NoteUnLieuEntity findById(Long id) {
        return em.find(NoteUnLieuEntity.class, id);
    }
     public List<NoteUnLieuEntity> rechercherNoteParCritere(CritereEntity critere) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NoteUnLieuEntity> query = cb
                .createQuery(NoteUnLieuEntity.class);
        // construction de la requete dynamique
        Root<NoteUnLieuEntity> root = query.from(NoteUnLieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("critere"),
                critere));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }
}
