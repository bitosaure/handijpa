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
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.http.Part;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@RequestScoped
public class AjouterLieuControleur implements Serializable {

    /**
     * Lieu que l'on souhaite ajouter
     */
    private LieuEntity lieu = new LieuEntity();

    /**
     * *
     * Liste des catégories présentes dans la base de données
     */
    private List<CategorieEntity> listeCategorie = new ArrayList<>();

    /**
     * code de la catégorie correspond au lieu
     */
    private String categ = "";
    /**
     * dao permettant de modifier la table Categorie de la base de données
     */
    private CategorieDAO categDao;

    /**
     * dao permettant de modifier la table lieu de la base de données
     */
    private LieuDAO lieuDao;

    /**
     * *
     * Imgae que l'on souhaite ajouter au lieu
     */
    private Part fichier;

    // Initialisation de l'entité utilisateur
    public AjouterLieuControleur() {
        categDao = new CategorieDAO();
        listeCategorie = categDao.findAll();
        lieu = new LieuEntity();

    }

    /**
     * *
     * Méthode appelée lorsque l'on souhaite consulter la page ajoutLieu.xhtml
     *
     * @return String permettant de savoir si les données nécessaires à la page
     * ont bien été initialisé
     */
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
    /**
     * mMéthode permettant d'ajouter le lieu saisie par l'utilisateur
     * @return String permettant de savoir si l'ajout a été réalisé ou pas
     */
    public String ajouter() {
        lieuDao = new LieuDAO();
        lieu.setCategorie(categDao.findById(categ));
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        lieu.setCreateur((PersonneEntity) binding.getValue(context));
        lieu.setEstValide(false);

        FacesMessage message = new FacesMessage("Succès de la création !");
        FacesContext.getCurrentInstance().addMessage(null, message);
        if (fichier != null) {
            String str = fichier.getSubmittedFileName();
            if (str.endsWith(".jpg")) {
                System.out.println("jpg");
                str = str.substring(0, str.length() - 4);
                System.out.println(str);
            }
            Path file = null;
            try {

                file = Files.createTempFile(Paths.get("/Users/emiliepisu/handijpa/web/images"), str, ".jpg");
                //InputStream in = fichier.getInputStream();
                System.out.println(file.getFileName());
                try (InputStream input = fichier.getInputStream()) {
                    Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                }
                lieu.setImage(file.getFileName().toString());

            } catch (IOException ex) {
                Logger.getLogger(AjouterLieuControleur.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 
        System.out.println(lieu.getCategorie());
        lieuDao.create(lieu);
        return "SUCCESS";

    }

    /**
     * retrourne le lieu qui doit être créé
     * @return the lieu que l'utilisateur souhaite créer
     */
    public LieuEntity getLieu() {
        return lieu;
    }

    /**
     * set le lieu avec le lieu passé en paramètre
     * @param lieu the lieu to set le lieu
     */
    public void setLieu(LieuEntity lieu) {
        this.lieu = lieu;
    }

    /**
     * retourne les catégories présents dans la base de données
     * @return the listeCategorie de tyoe List<CategorieEntity>
     */
    public List<CategorieEntity> getListeCategorie() {
        return listeCategorie;
    }

    /**
     * set la liste des catégories présents dans la base de données
     * @param listeCategorie the listeCategorie to set 
     */
    public void setListeCategorie(List<CategorieEntity> listeCategorie) {
        this.listeCategorie = listeCategorie;
    }

    /**
     * retourne le code de la catégorie du lieu choisi par l'utilisateur
     * @return the categ de type String
     */
    public String getCateg() {
        return categ;
    }

    /**
     * modifie le code de la catégorie du lieu choisi par l'utilisateur
     * @param categ the categ to set de type String
     */
    public void setCateg(String categ) {
        this.categ = categ;
    }

    /**
     * retourne l'image associé au lieu créé par l'utilisateur
     * @return the file associé au lieu de type Part
     **/
    public Part getFichier() {
        return fichier;
    }
    /***
     * MODIFIE l'image associé au lieu créé par l'utilisateur
     * @param fichier to set fichier de type Part
     */
    public void setFichier(Part fichier) {
        this.fichier = fichier;
    }
}
