/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.PersonneDAO;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author emiliepisu
 
 */
@ManagedBean
@SessionScoped
public class AuthentificationControleur implements Serializable{
    private PersonneEntity personne = new PersonneEntity();

    
    private PersonneDAO   personneDao;

    // Initialisation de l'entité utilisateur
    public AuthentificationControleur() {
        personne = new PersonneEntity();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'atuehtnification
    public void authentification() {
        personneDao   = new PersonneDAO();
        System.out.println("je rentre");
        personne.setLogin("toto");
        personne.setMdp("toto");
        personneDao.create(personne);
       
    }

    public PersonneEntity getPersonne() {
        return personne;
    }

    
}
