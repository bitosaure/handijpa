/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CommentaireLieuDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.NoteUnLieuDAO;
import fr.m1.miage.sorbonne.dao.SignalementCommentaireDAO;
import fr.m1.miage.sorbonne.dao.SignalementLieuDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
import fr.m1.miage.sorbonne.entity.SignalementLieuEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author emiliepisu
 */
@RequestScoped
@ManagedBean
public class SignalementLieuControleur implements Serializable {

    /**
     * DAO agissant sur la table signalementLieu
     */
    private SignalementLieuDAO signalementLieuDao;

    /**
     * LISTe des lieux signalés
     */
    private List<SignalementLieuEntity> listSignalementLieu;

    /**
     * DAO agissant sur la table LieuDao
     */
    private LieuDAO lieuDao;

    /**
     * *
     * Méthode appelée lors du chargement de la page
     */
    public String initialiserPage() {
        lieuDao = new LieuDAO();
        signalementLieuDao = new SignalementLieuDAO();
        setListSignalementLieu(signalementLieuDao.findAll());
        return "SUCCESS";
        
    }
    public SignalementLieuControleur(){
        lieuDao = new LieuDAO();
        signalementLieuDao = new SignalementLieuDAO();
        setListSignalementLieu(signalementLieuDao.findAll());
    }

    /**
     * mMéthode permettant de supprimer le lieu, les commentaires, notes, signalements associés à ce lieucd
     */
    public void supprimerLieu(SignalementLieuEntity sign) {
        System.out.println("je passe");
        LieuEntity lieu =sign.getLieu();

        List<NoteUnLieuEntity> listeNotes = lieu.getNotes();
        lieu.setNotes(new ArrayList<NoteUnLieuEntity>());
        
        lieuDao.update(lieu);
        
        NoteUnLieuDAO notelieuDAO ;
        for (NoteUnLieuEntity note : listeNotes) {
            notelieuDAO = new NoteUnLieuDAO();
            notelieuDAO.delete(note);
        }
        SignalementCommentaireDAO signCommentDAO = new SignalementCommentaireDAO();
        
        CommentaireLieuDAO commDao= new CommentaireLieuDAO();
        List<CommentaireLieuEntity> listCommDuLieu =commDao.rechercherCommentaireLieu(lieu);
        for(CommentaireLieuEntity com:listCommDuLieu){
            List<SignalementCommentaireEntity> listCSignalement =signCommentDAO.rechercherSiganlementCommentaire(com);
            

        }
                
        signalementLieuDao.delete(sign);
        lieuDao = new LieuDAO();
        lieuDao.delete(lieu);
        
    }
    
    public void afficherModifierLieu(SignalementLieuEntity sign) {
        
    }

    /**
     * @return the listSignalementLieu
     */
    public List<SignalementLieuEntity> getListSignalementLieu() {
        return listSignalementLieu;
    }

    /**
     * @param listSignalementLieu the listSignalementLieu to set
     */
    public void setListSignalementLieu(List<SignalementLieuEntity> listSignalementLieu) {
        this.listSignalementLieu = listSignalementLieu;
    }
    
}
