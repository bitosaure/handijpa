/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.AvisEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class AvisDAO implements DAO<AvisEntity> {

    /**
     * *
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;

    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public AvisDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    /**
     * *
     * Recupère tous les avis présents dans la base de données
     *
     * @return List<AvisEntity>
     */
    @Override
    public List findAll() {
        List<AvisEntity> listAvis = em.createQuery("Select a FROM AVIS a").getResultList();
        return listAvis;
    }

    /**
     * Méthode permettant de créer un avis dans la table avis de la base de
     * données
     *
     * @param obj de type avisEntity
     */
    @Override
    public void create(AvisEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * modifie le AvisEntity présent dans la base de données
     *
     * @param obj de type AvisEntity
     */
    @Override
    public void update(AvisEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Méthode permettant de supprimer le AvisEntity passé en paramère
     *
     * @param obj de type AvisEntity
     */
    @Override
    public void delete(AvisEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Méthode permettant de récuperer l'entité AvisEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type String
     * @return AvisEntity
     */
    public AvisEntity findById(String id) {
        return em.find(AvisEntity.class, id);
    }
}
