/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.SignalementLieuDAO;
import fr.m1.miage.sorbonne.entity.SignalementLieuEntity;
import java.io.Serializable;
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
     *  LISTe des lieux signalés
     */
    private List<SignalementLieuEntity> listSignalementLieu;
    
    /***
     * Méthode appelée lors du chargement de la page
     */
    public void initaliserPage(){
        signalementLieuDao= new SignalementLieuDAO();
        setListSignalementLieu(signalementLieuDao.findAll());

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
