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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author emiliepisu
 */
@ManagedBean
@SessionScoped
public class GererCommentaireControleur implements Serializable {

    
    private SignalementCommentaireDAO signalementDao;
    private List<SignalementCommentaireEntity> listCommentaireSiganles = new ArrayList<SignalementCommentaireEntity>();

    public String initialiserPage() {
        signalementDao= new SignalementCommentaireDAO();
        listCommentaireSiganles= signalementDao.findAll();
        return "SUCCESS";
    }
    
    
     public String supprimerCommentaire(SignalementCommentaireEntity sign) {
         SignalementCommentaireDAO signalementCommeDAO = new SignalementCommentaireDAO();
         
         CommentaireLieuEntity comm=sign.getCommentaireLieu();
         signalementCommeDAO.delete(sign);
         CommentaireLieuDAO commDAO = new CommentaireLieuDAO();
         commDAO.delete(comm);
        listCommentaireSiganles.remove(sign);

        
        return "SUCCESS";
    }
     
     public String validerCommentaire(SignalementCommentaireEntity sign) {
         SignalementCommentaireDAO signalementCommeDAO = new SignalementCommentaireDAO();
         signalementCommeDAO.delete(sign);
         listCommentaireSiganles.remove(sign);
         
        
        return "SUCCESS";
    }

    /**
     * @return the listCommentaireSiganles
     */
    public List<SignalementCommentaireEntity> getListCommentaireSiganles() {
        return listCommentaireSiganles;
    }

    /**
     * @param listCommentaireSiganles the listCommentaireSiganles to set
     */
    public void setListCommentaireSiganles(List<SignalementCommentaireEntity> listCommentaireSiganles) {
        this.listCommentaireSiganles = listCommentaireSiganles;
    }
}
