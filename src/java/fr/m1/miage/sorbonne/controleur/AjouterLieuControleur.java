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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import static javax.security.auth.message.AuthStatus.SUCCESS;
import javax.servlet.http.Part;


/**
 *
 * @author emiliepisu
 */
@ManagedBean
@RequestScoped
public class AjouterLieuControleur implements Serializable {

    private LieuEntity lieu = new LieuEntity();

    private List<CategorieEntity> listeCategorie = new ArrayList<>();

    private String categ = "";

    private CategorieDAO categDao;

    private LieuDAO lieuDao;

    private Part fichier;

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
        lieuDao = new LieuDAO();
       lieu.setCategorie(categDao.findById(categ));
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        //lieu.setCreateur((PersonneEntity) binding.getValue(context));
        lieu.setEstValide(false);
       
        

        FacesMessage message = new FacesMessage("Succès de la création !");
        FacesContext.getCurrentInstance().addMessage(null, message);
        String str = fichier.getSubmittedFileName();
        if(str.endsWith(".jpg")){
            System.out.println("jpg");
            str = str.substring(0, str.length()-4);
            System.out.println(str);
        }
        Path file = null;
        try {
            
            file = Files.createTempFile(Paths.get("/Users/emiliepisu/handijpa/web/images"),str,".jpg");
            //InputStream in = fichier.getInputStream();
            System.out.println(file.getFileName());
            try (InputStream input = fichier.getInputStream()){
                Files.copy(input, file,StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
            }
            
           
        } catch (IOException ex) {
            Logger.getLogger(AjouterLieuControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        lieu.setImage(file.getFileName().toString());
        lieuDao.create(lieu);
        
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

    /**
     * @return the categ
     */
    public String getCateg() {
        return categ;
    }

    /**
     * @param categ the categ to set
     */
    public void setCateg(String categ) {
        this.categ = categ;
    }

    public Part getFichier() {
        return fichier;
    }

    public void setFichier(Part fichier) {
        this.fichier = fichier;
    }
}
