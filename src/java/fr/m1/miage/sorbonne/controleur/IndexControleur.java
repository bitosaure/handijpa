/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author thibault
 */
@ManagedBean
@RequestScoped
public class IndexControleur implements Serializable{
    private LieuDAO lieux;
    
    public List<LieuEntity> recupererLieux(){
        lieux = new LieuDAO();
        for (LieuEntity  object : (List<LieuEntity>)lieux.findAll()) {
            System.out.println(object.getNom());
        }
        return lieux.findAll();
        
    }
}
