/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

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

    /**
     * *
     * entityManager permettant d'accéder à la base de données
     */
    private EntityManager em;

    /**
     * Constructeur permettant d'initaliser l'entité manager
     */
    public CategorieDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }
    /***
     * Recupère tous les CategorieEntity présents dans la base de données 
     * @return  List<CategorieEntity>
     */
    @Override
    public List findAll() {
        List<CategorieEntity> listCategorie = em.createQuery("Select c FROM CategorieEntity  c").getResultList();
        return listCategorie;
    }
    /***
     *  Méthode permettant de créer une catégorie dans la table catégorie de la base de données
     * @param obj de type CategorieEntity
     */
    @Override
    public void create(CategorieEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * modifie le CategorieEntity présent dans la base de données
     * @param obj de type CategorieEntity
     */
    @Override
    public void update(CategorieEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de supprimer le CategorieEntity passé en paramère
     * @param obj de type CategorieEntity
     */
    @Override
    public void delete(CategorieEntity obj) {
        em.getTransaction().begin();
        obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }
    /**
     * Méthode permettant de récuperer l'entité CategorieEntity présent dans la base
     * de données qui correspond à l'identifiant passé en parametre
     *
     * @param id de type String
     * @return CategorieEntity
     */
    public CategorieEntity findById(String id) {

        return em.find(CategorieEntity.class, id);
    }
}
