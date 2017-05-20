/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.NoteUnLieuDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.jasper.tagplugins.jstl.ForEach;

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
        
         if (listCriteres.size()==0){
                FacesMessage message = new FacesMessage("Il n'y a pas de critère de note ");
                  FacesContext.getCurrentInstance().addMessage(null, message);
            }
        return "SUCCESS";
     
    }
    
    public String ajouter(){
        critereDao=new CritereDAO();
        
        if(critereDao.findById(critere.getCode())==null){
            
            critereDao.create(critere);
            listCriteres.add(critere);
            
            FacesMessage message = new FacesMessage("l'ajout a bien été intégré!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            critere = new CritereEntity();
            return "SUCCESS";
        }
        
            FacesMessage message = new FacesMessage("un lieu avec le même code existe déjà");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "ERROR";
        
    
        
      
    }
    
    public String supprimer(CritereEntity cri){
        NoteUnLieuDAO notelieuDAO = new NoteUnLieuDAO();
        List<NoteUnLieuEntity> listeNote =notelieuDAO.rechercherNoteParCritere(cri);
        System.out.println("taille note " + listeNote.size());
        LieuDAO lieuDao = new LieuDAO();
        for(NoteUnLieuEntity note: listeNote){
            lieuDao = new LieuDAO();
            List<LieuEntity> listeLieu = lieuDao.rechercherLieuNoteParCritere(note);
            for (LieuEntity lieu: listeLieu) {
                lieu.getNotes().remove(note);
                
                lieuDao.update(lieu);
                
            }
            notelieuDAO = new NoteUnLieuDAO();
            notelieuDAO.delete(note);
        }
        
        
        critereDao=new CritereDAO();
        critereDao.delete(cri);
        listCriteres.remove(cri);
          FacesMessage message = new FacesMessage("la suppression a bien été réalisé");
            FacesContext.getCurrentInstance().addMessage(null, message);
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
