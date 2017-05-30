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
    /**
     * personne souhaitant s'inscrire
     */
     private PersonneEntity personne = new PersonneEntity();

    /**
     * DAO permettant de modifier les données présentes dans la table personnes
     */
    private PersonneDAO   personneDao;

    // Initialisation de l'entité utilisateur
    /**
     * CONSTRUCTEUR permettant d'inialiser la personne
     */
    public InscriptionControleur() {
        personne = new PersonneEntity();
    }
    /**
     * Mathode appelée lorsque l'utilisateur souhaite consulter la page inscription.xhtml
     * @return String permettant de savoir si toutes les données nécessaores ont été initialisé
     */
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
            personne.setTypePersonne("lambda");
             personneDao.create(personne);
        
             FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
              FacesContext.getCurrentInstance().addMessage( null, message );
                return "SUCCESS";
        }
       
       
    }

    /**
     * Retourne la personne qui doit être créé
     * @return PersonneEntity
     */
    public PersonneEntity getPersonne() {
        return personne;
    }
}
