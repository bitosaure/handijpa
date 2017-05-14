/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 *
 * @author emiliepisu
 */
@RequestScoped
@ManagedBean
public class ValiderLieuControleur implements Serializable{

    
     
     private List<LieuEntity> listEntity = new ArrayList<>();

     private LieuDAO lieuDao;
     
    // Initialisation de l'entité utilisateur
    public ValiderLieuControleur() {
        lieuDao= new LieuDAO();
        listEntity = lieuDao.findNonValider();
        
        
    }

    public String initialiserPage(){
            lieuDao= new LieuDAO();
            listEntity = lieuDao.findNonValider();
            
            
          
            return "SUCCESS";
       
        
    }
    
    public String supprimer(LieuEntity lieu){
      
        lieuDao.delete(lieu);
        return "SUCCESS";
    }
    
    public String valider(LieuEntity lieu){
        lieu.setEstValide(true);
        lieuDao.update(lieu);
        return "SUCCESS";
    }
    

    /**
     * @return the listEntity
     */
    public List<LieuEntity> getListEntity() {
        return listEntity;
    }

    /**
     * @param listEntity the listEntity to set
     */
    public void setListEntity(List<LieuEntity> listEntity) {
        this.listEntity = listEntity;
    }
    
    
}
