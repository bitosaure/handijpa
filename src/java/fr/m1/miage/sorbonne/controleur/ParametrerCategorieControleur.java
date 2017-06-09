/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
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
public class ParametrerCategorieControleur {

    /**
     * Liste des categorie
     */
    private List<CategorieEntity> listCategories;
    /**
     * DAO permettant de modifier les données présent dans la table categorie
     */
    private CategorieDAO categorieDao;

    /**
     * categorie que l'on souhaite créer
     */
    private CategorieEntity categorie = new CategorieEntity();

    /**
     * Constructeur permettant d'initaliser les variables nécessaires
     */
    public ParametrerCategorieControleur() {
        categorieDao = new CategorieDAO();
        listCategories = categorieDao.findAll();
    }

    /**
     * Methode appelée lorsque l'on souhaite consulter la page
     * parametrerCategorie.xhtmlx
     *
     * @return String permettant de savoir si la méthode a bien fonctionnée
     */
    public String initialiserPage() {
        categorieDao = new CategorieDAO();
        listCategories = categorieDao.findAll();

        if (listCategories.size() == 0) {
            FacesMessage message = new FacesMessage("Il n'y a pas de catégorie de note ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "SUCCESS";

    }

    /**
     * Methode permettant d'ajouter une catégorie passée en paramètre
     *
     * @return String permettant de savoir si l'ajout a bien été fonctionné
     */
    public void ajouter() {
        categorieDao = new CategorieDAO();

        if (categorieDao.findById(categorie.getCode()) == null) {

            categorieDao.create(categorie);
            listCategories.add(categorie);

            FacesMessage message = new FacesMessage("l'ajout a bien été intégré!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            categorie = new CategorieEntity();
        } else {

            FacesMessage message = new FacesMessage("une catégorie avec le même code existe déjà");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    /**
     * @return the listCategories
     */
    public List<CategorieEntity> getListCategories() {
        return listCategories;
    }

    /**
     * @param listCategories the listCategories to set
     */
    public void setListCategories(List<CategorieEntity> listCategories) {
        this.listCategories = listCategories;
    }

    /**
     * @return the categorie
     */
    public CategorieEntity getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }
}
