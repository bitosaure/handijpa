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
import javax.faces.bean.SessionScoped;

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
     * Signalement du lieu que l'on souhaite modifier
     */
    private SignalementLieuEntity signalementLieu;

    /**
     * *
     * Méthode appelée lors du chargement de la page
     */
    public String initialiserPage() {
        lieuDao = new LieuDAO();
        setSignalementLieuDao(new SignalementLieuDAO());
        setListSignalementLieu(getSignalementLieuDao().findAll());
        return "SUCCESS";

    }

    public SignalementLieuControleur() {
        lieuDao = new LieuDAO();
        signalementLieuDao = new SignalementLieuDAO();
        listSignalementLieu = signalementLieuDao.findAll();
    }

    /**
     * mMéthode permettant de supprimer le lieu, les commentaires, notes,
     * signalements associés à ce lieucd
     *
     * @param sign
     */
    public void supprimerLieu(SignalementLieuEntity sign) {
        System.out.println("je passe");
        LieuEntity lieu = sign.getLieu();

        List<NoteUnLieuEntity> listeNotes = lieu.getNotes();
        lieu.setNotes(new ArrayList<>());

        lieuDao.update(lieu);

        NoteUnLieuDAO notelieuDAO;
        for (NoteUnLieuEntity note : listeNotes) {
            notelieuDAO = new NoteUnLieuDAO();
            notelieuDAO.delete(note);
        }
        SignalementCommentaireDAO signCommentDAO;

        CommentaireLieuDAO commDao = new CommentaireLieuDAO();
        List<CommentaireLieuEntity> listCommDuLieu = commDao.rechercherCommentaireLieu(lieu);
        for (CommentaireLieuEntity com : listCommDuLieu) {
            signCommentDAO = new SignalementCommentaireDAO();
            List<SignalementCommentaireEntity> listCSignalement = signCommentDAO.rechercherSiganlementCommentaire(com);
            for (SignalementCommentaireEntity signalemComm : listCSignalement) {
                signCommentDAO = new SignalementCommentaireDAO();
                signCommentDAO.delete(signalemComm);
            }
            commDao = new CommentaireLieuDAO();
            commDao.delete(com);
        }
        List<SignalementLieuEntity> listSignLieu = getSignalementLieuDao().rechercherSiganlementLieu(lieu);
        for (SignalementLieuEntity signEntity : listSignLieu) {
            setSignalementLieuDao(new SignalementLieuDAO());
            getSignalementLieuDao().delete(signEntity);

        }
        setSignalementLieuDao(new SignalementLieuDAO());

        listSignalementLieu = getSignalementLieuDao().findAll();
        lieuDao = new LieuDAO();
        lieuDao.delete(lieu);

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

    /**
     * @return the signalementLieuDao
     */
    public SignalementLieuDAO getSignalementLieuDao() {
        return signalementLieuDao;
    }

    /**
     * @param signalementLieuDao the signalementLieuDao to set
     */
    public void setSignalementLieuDao(SignalementLieuDAO signalementLieuDao) {
        this.signalementLieuDao = signalementLieuDao;
    }

    /**
     * @return the signalementLieu
     */
    public SignalementLieuEntity getSignalementLieu() {
        return signalementLieu;
    }

    /**
     * @param signalementLieu the signalementLieu to set
     */
    public void setSignalementLieu(SignalementLieuEntity signalementLieu) {
        this.signalementLieu = signalementLieu;
    }

   

}
