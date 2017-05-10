/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.PersonneDAO;
import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import static javax.security.auth.message.AuthStatus.SUCCESS;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@SessionScoped
public class AjouterLieuControleur implements Serializable {

    private LieuEntity lieu = new LieuEntity();

    private List<CategorieEntity> listeCategorie = new ArrayList<>();

    private CategorieDAO categDao;
    private LieuDAO lieuDao;

    // Initialisation de l'entité utilisateur
    public AjouterLieuControleur() {
        categDao = new CategorieDAO();
        listeCategorie = categDao.findAll();
        lieu = new LieuEntity();
    }

    public String initialiserPage() {
        FacesContext context = FacesContext.getCurrentInstance();

        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.isAuthenti}");

        if ((boolean) binding.getValue(context)) {
            return "SUCCESS";
        }
        FacesMessage message = new FacesMessage("Vous devez vous authentifier avant d'ajouter un lieu!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "ERROR";

    }

    public String ajouter() {
        return "SUCCESS";
    }

    /**
     * @return the lieu
     */
    public LieuEntity getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(LieuEntity lieu) {
        this.lieu = lieu;
    }

    /**
     * @return the listeCategorie
     */
    public List<CategorieEntity> getListeCategorie() {
        return listeCategorie;
    }

    /**
     * @param listeCategorie the listeCategorie to set
     */
    public void setListeCategorie(List<CategorieEntity> listeCategorie) {
        this.listeCategorie = listeCategorie;
    }

}
