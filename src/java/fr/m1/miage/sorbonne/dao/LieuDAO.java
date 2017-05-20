/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
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
public class LieuDAO implements DAO<LieuEntity> {

    private EntityManager em;

    public LieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    @Override
    public List<LieuEntity> findAll() {

        List<LieuEntity> listLieuEntity = em.createQuery("Select a FROM LieuEntity a").getResultList();

        return listLieuEntity;
    }

    public List findNonValider() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LieuEntity> query = cb
                .createQuery(LieuEntity.class);
        // construction de la requete dynamique
        Root<LieuEntity> root = query.from(LieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("estValide"),
                false));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }
    
     public List<LieuEntity> rechercherLieuNoteParCritere(NoteUnLieuEntity note) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LieuEntity> query = cb
                .createQuery(LieuEntity.class);
        // construction de la requete dynamique
        Root<LieuEntity> root = query.from(LieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("notes"),
                note));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }

    public List findValider() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LieuEntity> query = cb
                .createQuery(LieuEntity.class);
        // construction de la requete dynamique
        Root<LieuEntity> root = query.from(LieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("estValide"),
                true));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }

    @Override
    public void create(LieuEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(LieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }
 @Override
    public void delete(LieuEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    public LieuEntity findById(String id) {
        System.out.println(id);
        Long idd = Long.parseLong(id);
        return em.find(LieuEntity.class, idd);

    }
    
    
    public LieuEntity findByIdLong(Long id) {
        //Long idd = Long.parseLong(id);
        return em.find(LieuEntity.class, id);

    }
}
