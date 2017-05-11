/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
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
public class PersonneDAO implements DAO<PersonneEntity>{
     
    private EntityManager em;

    public PersonneDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

   
    @Override
    public List findAll() {
        List<PersonneEntity> listPersonneEntity = em.createQuery("Select a FROM PERSONNE a").getResultList();
        return listPersonneEntity;
    }
    public List<PersonneEntity> rechercherPersonnesAvecLogin(String login ) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PersonneEntity> query = cb
				.createQuery(PersonneEntity.class);
		// construction de la requete dynamique
		Root<PersonneEntity> root = query.from(PersonneEntity.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		
			predicateList.add(cb.equal(root.<String> get("login"),
					login));
		

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(predicates);
		// exécution de la requete
		return em.createQuery(query).getResultList();
	}
    
     public List<PersonneEntity> rechercherPersonnesAvecLoginAnMdp(String login, String mdp ) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PersonneEntity> query = cb
				.createQuery(PersonneEntity.class);
		// construction de la requete dynamique
		Root<PersonneEntity> root = query.from(PersonneEntity.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		
			predicateList.add(cb.equal(root.<String> get("login"),
					login));
                       predicateList.add(cb.equal(root.<String> get("mdp"),
					mdp));
		

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(predicates);
		// exécution de la requete
		return em.createQuery(query).getResultList();
	}
    @Override
    public void create(PersonneEntity obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public void update(PersonneEntity obj) {
        em.getTransaction().begin();
         em.merge(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public void delete(PersonneEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public PersonneEntity findById(String id) {
        return em.find(PersonneEntity.class, id);
    }
}
