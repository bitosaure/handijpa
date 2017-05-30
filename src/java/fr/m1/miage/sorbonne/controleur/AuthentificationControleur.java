/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.PersonneDAO;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author emiliepisu
 *
 */
@ManagedBean
@SessionScoped
public class AuthentificationControleur implements Serializable {

    /**
     * Personne qui souhaite s'authentifier
     */
    private PersonneEntity personne = new PersonneEntity();

    /**
     * DAO permettant de modifier les données de la table personne
     */
    private PersonneDAO personneDao;

    /**
     * boolean permettant de savoir si la personne est authentifié
     */
    private boolean isAuthenti = false;

    // Initialisation de l'entité utilisateur
    public AuthentificationControleur() {
        isAuthenti = false;
        personne = new PersonneEntity();
    }

    /**
     * Méthode appelée lorsque l'utilisateur souhaite accèder à la page
     * authentification.xhtml pour s'authentifier
     *
     * @return String permettant de savoir si la méthode a générer des erreurs
     */
    public String initialiserPage() {
        return "SUCCESS";
    }

    /**
     * Méthode permettant de se déconnecter
     * @return String permettant de savoir si l'utilisateur s'est bien deconnecté
     */
    public String seDeconnecter() {
        isAuthenti = false;

        personne = new PersonneEntity();
        return "SUCCESS";
    }

   
    
    /**
     * Méthode d'action appelée lors du clic sur le bouton du formulaire
    * d'atuehtnification
     * @return String permettant de savoir si la personne a bien été authentifier
     * success si le login + mot de passe de la personne a été trouvé
     * sinon error
     */
    public String authentification() {
        personneDao = new PersonneDAO();
        List<PersonneEntity> listPers = personneDao.rechercherPersonnesAvecLoginAnMdp(personne.getLogin(), personne.getMdp());
        if (listPers.size() == 0) {
            FacesMessage message = new FacesMessage("login ou mot de passe incorrect!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return "ERROR";
        } else {
            personne = listPers.get(0);
            System.out.println("type pers" + personne.getTypePersonne());
            FacesMessage message = new FacesMessage("succès de l'authentification!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            isAuthenti = true;

            return "SUCCESS";
        }

    }

    /**
     * retounre la personne souhaitant s'authentifier
     * @return la personne qui souhaite s'authentifier de type PersonneEntity
     */
    public PersonneEntity getPersonne() {
        return personne;
    }

    /**
     * retourne un boolean permettant de savoir si la personne est authentifié
     * @return the isAuthenti de tyoe boolean
     */
    public boolean isIsAuthenti() {
        return isAuthenti;
    }

    /**
     * set the  boolean permettant de savoir si la personne est authentifié
     * @param isAuthenti the isAuthenti to set s
     */
    public void setIsAuthenti(boolean isAuthenti) {
        this.isAuthenti = isAuthenti;
    }

}
