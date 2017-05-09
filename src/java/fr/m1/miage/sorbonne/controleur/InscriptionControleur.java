/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.PersonneDAO;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thibault
 */
@ManagedBean
@SessionScoped
public class InscriptionControleur implements Serializable{
     private PersonneEntity personne = new PersonneEntity();

    
    private PersonneDAO   personneDao;

    // Initialisation de l'entité utilisateur
    public InscriptionControleur() {
        personne = new PersonneEntity();
    }

    public String initialiserPage(){
        personne = new PersonneEntity();
        return "SUCCESS";
    }
    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'atuehtnification
    public String inscrire() {
        personneDao   = new PersonneDAO();
        if(personneDao.rechercherPersonnesAvecLogin(personne.getLogin()).size()>0){
              FacesMessage message = new FacesMessage( "login déjà existant !" );
              FacesContext.getCurrentInstance().addMessage( null, message );
                return "ERROR";
        }
        else{
             personneDao.create(personne);
        
             FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
              FacesContext.getCurrentInstance().addMessage( null, message );
                return "SUCCESS";
        }
       
       
    }

    public PersonneEntity getPersonne() {
        return personne;
    }
}
