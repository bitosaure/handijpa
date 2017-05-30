/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
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
public class CommentaireLieuDAO implements DAO<CommentaireLieuEntity> {

    /**
     * *
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;

    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public CommentaireLieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }
    /***
     *  Méthode permettant de créer un commentaire dans la table commentaire de la base de données
     * @param obj de type CommentaireLieuEntity
     */
    @Override
    public void create(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de récuperer l'entité CommentaireLieuEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type String
     * @return CommentaireLieuEntity
     */
    public CommentaireLieuEntity findById(Long id) {
        return em.find(CommentaireLieuEntity.class, id);
    }

    /**
     * methode recupérant les commentaires du lieu passé en paramètre
     * @param lieu de type LieuEntity
     * @return List<CommentaireLieuEntity>
     */
    public List<CommentaireLieuEntity> rechercherCommentaireLieu(LieuEntity lieu) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CommentaireLieuEntity> query = cb
                .createQuery(CommentaireLieuEntity.class);
        // construction de la requete dynamique
        Root<CommentaireLieuEntity> root = query.from(CommentaireLieuEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("lieu"),
                lieu));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }
    /**
     * modifie le CommentaireLieuEntity présent dans la base de données
     * @param obj de type CommentaireLieuEntity
     */
    @Override
    public void update(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de supprimer le CommentaireLieuEntity passé en paramère
     * @param obj de type CommentaireLieuEntity
     */
    @Override
    public void delete(CommentaireLieuEntity obj) {
        obj = this.findById(obj.getId());
        em.getTransaction().begin();
        em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }
    /***
     * Recupère tous les CommentaireLieuEntity présents dans la base de données 
     * @return  List<CommentaireLieuEntity>
     */
    @Override
    public List<CommentaireLieuEntity> findAll() {
        List<CommentaireLieuEntity> listPCommentaireLieuEntity = em.createQuery("Select a FROM CommentaireLieuEntity a").getResultList();
        return listPCommentaireLieuEntity;
    }

}
