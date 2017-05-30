/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
import fr.m1.miage.sorbonne.entity.SignalementLieuEntity;
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
public class SignalementCommentaireDAO implements DAO<SignalementCommentaireEntity> {

    /**
     * *
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;

    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public SignalementCommentaireDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    /**
     * Méthode permettant de créer un signalement d'un commentaore dans la table
     * SIGNALEMENTCOMMENTAIRE de la base de données
     *
     * @param obj de type SignalementCommentaireEntity
     */
    @Override
    public void create(SignalementCommentaireEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de récuperer l'entité SignalementCommentaireEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type String
     * @return SignalementCommentaireEntity
     */
    public SignalementCommentaireEntity findById(String id) {
        return em.find(SignalementCommentaireEntity.class, id);
    }
    /**
     * modifie le SignalementCommentaireEntity présent dans la base de données
     * @param obj de type SignalementCommentaireEntity
     */
    @Override
    public void update(SignalementCommentaireEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    
    /**
     * Méthode permettant de supprimer le SignalementCommentaireEntity passé en paramère
     * @param obj de type SignalementCommentaireEntity
     */
    @Override
    public void delete(SignalementCommentaireEntity obj) {
        em.getTransaction().begin();
        obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }
    /***
     * Recupère tous les SignalementCommentaireEntity présents dans la base de données 
     * @return  List<SignalementCommentaireEntity>
     */
    @Override
    public List<SignalementCommentaireEntity> findAll() {
        List<SignalementCommentaireEntity> listSignalementCommentaireEntity = em.createQuery("Select a FROM SignalementCommentaireEntity a").getResultList();
        return listSignalementCommentaireEntity;
    }
    /**
     * Recupere les signalements qui sont associé au commentaire passé en paramètre
     * @param comm de type CommentaireLieuEntity,
     * @return List<SignalementCommentaireEntity>
     */
    public List<SignalementCommentaireEntity> rechercherSiganlementCommentaire(CommentaireLieuEntity comm) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SignalementCommentaireEntity> query = cb
                .createQuery(SignalementCommentaireEntity.class);
        // construction de la requete dynamique
        Root<SignalementCommentaireEntity> root = query.from(SignalementCommentaireEntity.class);
        List<Predicate> predicateList = new ArrayList<Predicate>();

        predicateList.add(cb.equal(root.<String>get("commentaireLieu"),
                comm));

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);
        // exécution de la requete
        return em.createQuery(query).getResultList();
    }

}
