/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.LieuEntity;
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
@RequestScoped
@ManagedBean
public class ValiderLieuControleur implements Serializable {

    /***
     * Liste des lieux que l'administrateur doit valider ou non
     */
    private List<LieuEntity> listEntity = new ArrayList<>();
    /**
     * dao permettant de modifier les lieux présents dans la base de données
     */
    private LieuDAO lieuDao;

    // Initialisation de l'entité utilisateur
    public ValiderLieuControleur() {
        lieuDao = new LieuDAO();
        listEntity = lieuDao.findNonValider();

    }
    /***
     * Methode appelée lorsque l'utilisateur souhaite accèder à la page validerLieu.xhtml
     * @return 
     */
    public String initialiserPage() {
        lieuDao = new LieuDAO();

        listEntity = lieuDao.findNonValider();
        if (listEntity.size() == 0) {
            FacesMessage message = new FacesMessage("Il n'y a pas de lieu à valider ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        return "SUCCESS";

    }
    /***
     * M2THODE pour supprimer le lieu passé en paramètre
     * @param lieu
     * @return String permettant de savoir si le lieu a bien été supprimé
     */
    public String supprimer(LieuEntity lieu) {

        lieuDao.delete(lieu);
        initialiserPage();
        return "SUCCESS";
    }

    /***
     * méthode permettant de valider le lieu passé en paramètre
     * @param lieu
     * @return String permettant de savoir si le lieu a bien été validé
     */
    public String valider(LieuEntity lieu) {

        lieu.setEstValide(true);
        lieuDao.update(lieu);
        initialiserPage();

        return "SUCCESS";
    }

    /**
     * retourne la liste des lieux qu'il faut valider
     * @return the listEntity
     */
    public List<LieuEntity> getListEntity() {
        return listEntity;
    }

    /**
     * set la liste des lieux
     * @param listEntity the listEntity to set
     */
    public void setListEntity(List<LieuEntity> listEntity) {
        this.listEntity = listEntity;
    }

}
