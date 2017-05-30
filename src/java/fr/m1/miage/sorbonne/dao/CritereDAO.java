/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CritereEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author emiliepisu
 */
public class CritereDAO implements DAO<CritereEntity>{
     /***
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;
    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public CritereDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }
    /**
     *  Méthode permettant de créer un critère dans la table critère de la base de données
     * @param obj de type CritereEntity
     */
    @Override
    public void create(CritereEntity obj) {
         em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();     }
    /**
     * Méthode permettant de récuperer l'entité CritereEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type String
     * @return CritereEntity
     */
    public CritereEntity findById(String id) {
        return em.find(CritereEntity.class, id);
    }
    /**
     * modifie le CritereEntity présent dans la base de données
     * @param obj de type CritereEntity
     */
    @Override
    public void update(CritereEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.close();     }
    
    /**
     * Méthode permettant de supprimer le CritereEntity passé en paramère
     * @param obj de type CritereEntity
     */
    @Override
    public void delete(CritereEntity obj) {
        em.getTransaction().begin();
                 obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }
    /***
     * Recupère tous les CritereEntity présents dans la base de données 
     * @return  List<CritereEntity>
     */
    @Override
    public List<CritereEntity> findAll() {
        List<CritereEntity> listCritereEntity= em.createQuery("Select a FROM CritereEntity a").getResultList();
        return listCritereEntity;   
    }
    
}
