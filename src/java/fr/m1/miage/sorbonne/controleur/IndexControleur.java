/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author thibault
 */
@ManagedBean
@RequestScoped
public class IndexControleur implements Serializable {

    /**
     * DAO permettant de modifier les données présentes dans la base de données
     */
    private LieuDAO lieux;

    /**
     * *
     * La liste des 5 meilleurs lieux
     */
    private List<LieuEntity> lieuxIndex;

    /**
     * *
     * Constructeur permettant d'injecter les lieux présents dans la base de
     * données au sein de la liste
     */
    public IndexControleur() {
        this.setLieuxIndex(lieuxIndex);
    }

    
    /***
     * méthode permettant de lister les lieux présents dans la base de données
     * @return List<LieuEntity> les listes dans la base de données
     */
    private List<LieuEntity> recupererLieux() {
        lieux = new LieuDAO();
        List<LieuEntity> maListe = new ArrayList<>();
        List<LieuEntity> listeBd = lieux.findAll();
        int flag = 5;
        if (listeBd.size() < flag) {
            flag = listeBd.size();
        }

        for (int i = 0; i < flag; i++) {
            listeBd.get(i).setImage("http://localhost:55857/handijpa3/images/" + listeBd.get(i).getImage());
            System.out.println(listeBd.get(i).getImage());
            maListe.add(listeBd.get(i));
        }

        return maListe;

    }

    /***
     * Retounre la liste des lieux présents dans la vase de données
     * @return List<LieuEntity>
     */
    public List<LieuEntity> getLieuxIndex() {
        return lieuxIndex;
    }
    /**
     * * set la liste des lieux
     * @param List<LieuEntity>
     * */
    public void setLieuxIndex(List<LieuEntity> lieuxIndex) {
        this.lieuxIndex = recupererLieux();
    }
}
