/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CommentaireLieuDAO;
import fr.m1.miage.sorbonne.dao.SignalementCommentaireDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@SessionScoped
public class GererCommentaireControleur implements Serializable {

    /**
     * DAO permettant de modifier les données de la table signalementCommentaire
     */
    private SignalementCommentaireDAO signalementDao;
   
    /***
     * Liste des signalements des commentaires
     */
    private List<SignalementCommentaireEntity> listCommentaireSiganles;

    
    /***
     * Methode appelée lorsque l'on souhaite consulter la page gererCommentaire.xhtml
     * @return String permettant de savoir si les données ont bien été intitialisées
     */
    public String initialiserPage() {
        setSignalementDao(new SignalementCommentaireDAO());
        listCommentaireSiganles= getSignalementDao().findAll();
         if (listCommentaireSiganles.size()==0){
                FacesMessage message = new FacesMessage("Aucun commentaire n'a été signalé");
                  FacesContext.getCurrentInstance().addMessage(null, message);
            }
        return "SUCCESS";
    }
    
    /***
     * méthode permettant de supprimer un commentaire passé en paramètre
     * @param sign de type SignalementCommentaireEntity
     * @return String permettant de savoir si le commentaire a bien été supprimé
     */
     public String supprimerCommentaire(SignalementCommentaireEntity sign) {
          setSignalementDao(new SignalementCommentaireDAO());
         
         CommentaireLieuEntity comm=sign.getCommentaireLieu();
         getSignalementDao().delete(sign);
         CommentaireLieuDAO commDAO = new CommentaireLieuDAO();
         commDAO.delete(comm);
        listCommentaireSiganles.remove(sign);

        
        return "SUCCESS";
    }
     
     
     /**
      * Methode permettant de valider un commentaire passé en paramètre
      * @param sign
      * @return 
      */
     public String validerCommentaire(SignalementCommentaireEntity sign) {
          setSignalementDao(new SignalementCommentaireDAO());
         getSignalementDao().delete(sign);
         listCommentaireSiganles.remove(sign);
         
        
        return "SUCCESS";
    }

    /**
     * retourne la liste des commentaires signalés
     * @return the listCommentaireSiganles
     */
    public List<SignalementCommentaireEntity> getListCommentaireSiganles() {
        return listCommentaireSiganles;
    }

    /**
     * set liste des commentaires signalés
     * @param listCommentaireSiganles the listCommentaireSiganles to set
     */
    public void setListCommentaireSiganles(List<SignalementCommentaireEntity> listCommentaireSiganles) {
        this.listCommentaireSiganles = listCommentaireSiganles;
    }

    /**
     * @return the signalementDao
     */
    public SignalementCommentaireDAO getSignalementDao() {
        return signalementDao;
    }

    /**
     * @param signalementDao the signalementDao to set
     */
    public void setSignalementDao(SignalementCommentaireDAO signalementDao) {
        this.signalementDao = signalementDao;
    }
}
