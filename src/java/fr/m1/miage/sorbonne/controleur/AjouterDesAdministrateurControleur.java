/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.PersonneDAO;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@RequestScoped
public class AjouterDesAdministrateurControleur implements Serializable {

    /**
     * *
     * Listes des personnes qui ne sont pas administrateurs
     */
    private List<PersonneEntity> listesPersonnes = new ArrayList<>();

    /**
     * DAO permettant de gérer les données de la table Personne
     */
    private PersonneDAO persDao;

    /**
     * Constructeur ne prenant aucun paramètre initaliser persDao appel de la
     * dao pour pousser les personnes non administrateurs dans la liste persDao
     */
    public AjouterDesAdministrateurControleur() {
        persDao = new PersonneDAO();
        listesPersonnes = persDao.rechercherPersonnesNonAdmin();
    }

    /**
     * *
     * constructeur prenant en paramètre une liste de personne
     *
     * @param listPers
     */
    public AjouterDesAdministrateurControleur(List<PersonneEntity> listPers) {
        listesPersonnes = listPers;
    }

    /**
     * *
     * méthode appelée lorsque l'on souhaite consulter la page
     * ajouterAdmin.xhtml
     *
     * @return String
     */
    public String initialiserPage() {
        if (listesPersonnes.size() == 0) {
            FacesMessage message = new FacesMessage("Il n'y a pas d'administrateur à valider ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        return "SUCCESS";

    }

    /**
     * *
     * Méthode permettant de donner le statut admin à la personne passée en
     * paramètre
     *
     * @param pers de type PersonneEntity
     * @return String
     */
    public String ajouterAdmin(PersonneEntity pers) {

        pers.setTypePersonne("admin");

        persDao.update(pers);
        FacesMessage message = new FacesMessage("La personne est devenue un administrateur ");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "SUCCESS";

    }

    /**
     * retourne la liste des personnes administrateurs
     *
     * @return the listesPersonnes de type List<PersonneEntity>
     */
    public List<PersonneEntity> getListesPersonnes() {
        return listesPersonnes;
    }

    /**
     * set la liste des personnes administrateurs
     *
     * @param listesPersonnes de type List<PersonneEntity>
     */
    public void setListesPersonnes(List<PersonneEntity> listesPersonnes) {
        this.listesPersonnes = listesPersonnes;
    }
}
