/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
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
public class CommentaireLieuDAO implements DAO<CommentaireLieuEntity>{
     
    private EntityManager em;

    public CommentaireLieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(CommentaireLieuEntity obj) {
         em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();     }

    @Override
    public CommentaireLieuEntity findById(String id) {
        return em.find(CommentaireLieuEntity.class, id);
    }
    
    public List<CommentaireLieuEntity> rechercherCommentaireLieu(LieuEntity lieu ) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CommentaireLieuEntity> query = cb
				.createQuery(CommentaireLieuEntity.class);
		// construction de la requete dynamique
		Root<CommentaireLieuEntity> root = query.from(CommentaireLieuEntity.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		
			predicateList.add(cb.equal(root.<String> get("lieu"),
					lieu));
		

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(predicates);
		// exécution de la requete
		return em.createQuery(query).getResultList();
	}
    @Override
    public void update(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();     }

    @Override
    public void delete(CommentaireLieuEntity obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public List<CommentaireLieuEntity> findAll() {
        List<CommentaireLieuEntity> listPCommentaireLieuEntity = em.createQuery("Select a FROM CommentaireLieuEntity a").getResultList();
        return listPCommentaireLieuEntity;   
    }
}
