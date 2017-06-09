/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.NoteUnLieuDAO;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import java.io.Serializable;
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
public class ParametrerNotationControleur implements Serializable {

    /**
     * Liste des critères de notation
     */
    private List<CritereEntity> listCriteres;
    /**
     * DAO permettant de modifier les données présent dans la table Critere
     */
    private CritereDAO critereDao;

    /**
     * critere que l'on souhaite créer
     */
    private CritereEntity critere = new CritereEntity();

    /**
     * Constructeur permettant d'initaliser les variables nécessaires
     */
    public ParametrerNotationControleur() {
        critereDao = new CritereDAO();
        setListCriteres(critereDao.findAll());
    }

    /**
     * Methode appelée lorsque l'on souhaite consulter la page
     * parametrerNotation.xhtmlx
     *
     * @return String permettant de savoir si la méthode a bien fonctionnée
     */
    public String initialiserPage() {
        critereDao = new CritereDAO();
        setListCriteres(critereDao.findAll());

        if (listCriteres.size() == 0) {
            FacesMessage message = new FacesMessage("Il n'y a pas de critère de note ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "SUCCESS";

    }
    /**
     * Methode permettant d'ajouter un critère de notation passée en paramètre
     * @return String permettant de savoir si l'ajout a bien été fonctionné
     */
    public String ajouter() {
        critereDao = new CritereDAO();

        if (critereDao.findById(critere.getCode()) == null) {

            critereDao.create(critere);
            listCriteres.add(critere);

            FacesMessage message = new FacesMessage("l'ajout a bien été intégré!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            critere = new CritereEntity();
            return "SUCCESS";
        }

        FacesMessage message = new FacesMessage("un lieu avec le même code existe déjà");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "ERROR";

    }
    /**
     * Methode permettant de supprimer un critère passé en paramètre
     * @param cri de type CritereEntity
     * @return String
     */
    public String supprimer(CritereEntity cri) {
        NoteUnLieuDAO notelieuDAO = new NoteUnLieuDAO();
        List<NoteUnLieuEntity> listeNote = notelieuDAO.rechercherNoteParCritere(cri);
        System.out.println("taille note " + listeNote.size());
        LieuDAO lieuDao = new LieuDAO();
        for (NoteUnLieuEntity note : listeNote) {
            lieuDao = new LieuDAO();
            List<LieuEntity> listeLieu = lieuDao.rechercherLieuNoteParCritere(note);
            for (LieuEntity lieu : listeLieu) {
                lieu.getNotes().remove(note);

                lieuDao.update(lieu);

            }
            notelieuDAO = new NoteUnLieuDAO();
            notelieuDAO.delete(note);
        }

        critereDao = new CritereDAO();
        critereDao.delete(cri);
        listCriteres.remove(cri);
        FacesMessage message = new FacesMessage("la suppression a bien été réalisé");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println("je rentre");
        return "SUCCESS";
    }

    /**
     * méthode listant tous les crit§res de notation
     * @return the listCriteres de type List<CritereEntity>
     */
    public List<CritereEntity> getListCriteres() {
        return listCriteres;
    }

    /**
     * set la liste des critères
     * @param listCriteres the listCriteres to set
     */
    public void setListCriteres(List<CritereEntity> listCriteres) {
        this.listCriteres = listCriteres;
    }

    /**
     * retourne le critère que l'utilisateur souhaite créer
     * @return the critere 
     */
    public CritereEntity getCritere() {
        return critere;
    }

    /**
     * set le critère que l'utilisateur souhaite créer
     * @param critere the critere to set
     */
    public void setCritere(CritereEntity critere) {
        this.critere = critere;
    }
}
