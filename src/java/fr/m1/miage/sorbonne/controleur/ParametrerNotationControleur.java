/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author emiliepisu
 */
@RequestScoped
@ManagedBean
public class ParametrerNotationControleur implements Serializable{
    
    
    private List<CritereEntity> listCriteres;
    
    private CritereDAO critereDao;
    
    private CritereEntity critere= new CritereEntity();
    
    public ParametrerNotationControleur(){
         critereDao=new CritereDAO();
        setListCriteres(critereDao.findAll());
    }
    
    
    public String initialiserPage(){
        critereDao=new CritereDAO();
        setListCriteres(critereDao.findAll());
        return "SUCCESS";
     
    }
    
    public String ajouter(){
        critereDao=new CritereDAO();
        critereDao.create(critere);
        listCriteres.add(critere);
        return "SUCCESS";
    }
    
    public String supprimer(CritereEntity cri){
        critereDao=new CritereDAO();
        critereDao.delete(cri);
        
        System.out.println("je rentre");
        return "SUCCESS";
    }

    /**
     * @return the listCriteres
     */
    public List<CritereEntity> getListCriteres() {
        return listCriteres;
    }

    /**
     * @param listCriteres the listCriteres to set
     */
    public void setListCriteres(List<CritereEntity> listCriteres) {
        this.listCriteres = listCriteres;
    }

    /**
     * @return the critere
     */
    public CritereEntity getCritere() {
        return critere;
    }

    /**
     * @param critere the critere to set
     */
    public void setCritere(CritereEntity critere) {
        this.critere = critere;
    }
}
