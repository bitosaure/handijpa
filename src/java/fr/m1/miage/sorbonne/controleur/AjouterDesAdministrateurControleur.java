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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@RequestScoped
public class AjouterDesAdministrateurControleur implements Serializable{
    
    private List<PersonneEntity> listesPersonnes;
    
    private PersonneDAO persDao;
    public String initialiserPage() {
        persDao=new PersonneDAO();
        
        setListesPersonnes(persDao.rechercherPersonnesNonAdmin());
        return "SUCCESS";

    }
    
    public String ajouterAdmin (PersonneEntity pers){
        pers.setTypePersonne("admin");
        persDao.update(pers);
        return "SUCCESS";
    }

    /**
     * @return the listesPersonnes
     */
    public List<PersonneEntity> getListesPersonnes() {
        return listesPersonnes;
    }

    /**
     * @param listesPersonnes the listesPersonnes to set
     */
    public void setListesPersonnes(List<PersonneEntity> listesPersonnes) {
        this.listesPersonnes = listesPersonnes;
    }
}
