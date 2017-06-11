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

    /**
     * *
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;
    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public LieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }
    /***
     * Recupère tous les LieuEntity présents dans la base de données 
     * @return  List<LieuEntity>
     */
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
    public List findAvecImage() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LieuEntity> query = cb
                .createQuery(LieuEntity.class);
        // construction de la requete dynamique
        Root<LieuEntity> root = query.from(LieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.notEqual(root.<String>get("image"),
                ""));

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
    /***
     *  Méthode permettant de créer un lieu dans la table LIEU de la base de données
     * @param obj de type LieuEntity
     */
    @Override
    public void create(LieuEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * modifie le LieuEntity présent dans la base de données
     * @param obj de type LieuEntity
     */
    @Override
    public void update(LieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de supprimer le LieuEntity passé en paramère
     * @param obj de type LieuEntity
     */
    @Override
    public void delete(LieuEntity obj) {
        obj = this.findById(obj.getId());
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de récuperer l'entité LieuEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type Long
     * @return LieuEntity
     */
    public LieuEntity findById(Long id) {
        return em.find(LieuEntity.class, id);

    }
    /**
     * Méthode permettant de récuperer l'entité LieuEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type Long
     * @return LieuEntity
     */
    public LieuEntity findByIdLong(Long id) {
        //Long idd = Long.parseLong(id);
        return em.find(LieuEntity.class, id);

    }
}
