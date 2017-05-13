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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 *
 * @author emiliepisu
 *
 */
@ManagedBean
@SessionScoped
public class AuthentificationControleur implements Serializable {

    private PersonneEntity personne = new PersonneEntity();

    private PersonneDAO personneDao;

    private boolean isAuthenti = false;

    // Initialisation de l'entité utilisateur
    public AuthentificationControleur() {
        isAuthenti = false;
        personne = new PersonneEntity();
    }

    public String initialiserPage() {
        return "SUCCESS";
    }

    public String seDeconnecter() {
        isAuthenti = false;

        personne = new PersonneEntity();
        return "SUCCESS";
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'atuehtnification
    public String authentification() {
        personneDao = new PersonneDAO();
        List<PersonneEntity> listPers = personneDao.rechercherPersonnesAvecLoginAnMdp(personne.getLogin(), personne.getMdp());
        if (listPers.size() == 0) {
            FacesMessage message = new FacesMessage("login ou mot de passe incorrect!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return "ERROR";
        } else {
            personne = listPers.get(0);
            System.out.println("type pers" +personne.getTypePersonne());
            FacesMessage message = new FacesMessage("succès de l'authentification!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            isAuthenti = true;

            return "SUCCESS";
        }

    }

    public PersonneEntity getPersonne() {
        return personne;
    }

    /**
     * @return the isAuthenti
     */
    public boolean isIsAuthenti() {
        return isAuthenti;
    }

    /**
     * @param isAuthenti the isAuthenti to set
     */
    public void setIsAuthenti(boolean isAuthenti) {
        this.isAuthenti = isAuthenti;
    }

}
