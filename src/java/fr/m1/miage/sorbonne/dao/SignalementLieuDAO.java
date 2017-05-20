/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.dao;

import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
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
public class SignalementLieuDAO implements DAO<SignalementLieuEntity>{
     
    private EntityManager em;

    public SignalementLieuDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handijpaPU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(SignalementLieuEntity obj) {
         em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();     }
    
    
        public List<SignalementLieuEntity> rechercherSiganlementLieu(LieuEntity lieu ) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SignalementLieuEntity> query = cb
				.createQuery(SignalementLieuEntity.class);
		// construction de la requete dynamique
		Root<SignalementLieuEntity> root = query.from(SignalementLieuEntity.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		
			predicateList.add(cb.equal(root.<String> get("lieu"),
					lieu));
		

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(predicates);
		// exécution de la requete
		return em.createQuery(query).getResultList();
	}
 
    public SignalementLieuEntity findById(String id) {
        return em.find(SignalementLieuEntity.class, id);
    }

    @Override
    public void update(SignalementLieuEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.close();     }
     @Override
    public void delete(SignalementLieuEntity obj) {
        em.getTransaction().begin();
                 obj = em.merge(obj);

        em.remove(obj);
        em.getTransaction().commit();
        em.close();    }

    @Override
    public List<SignalementLieuEntity> findAll() {
        List<SignalementLieuEntity> listSignalementLieuEntity= em.createQuery("Select a FROM SignalementLieuEntity a").getResultList();
        return listSignalementLieuEntity;   
    }
    
}
