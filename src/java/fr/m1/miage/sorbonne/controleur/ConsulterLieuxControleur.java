/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 *
 * @author thibault
 */
@ManagedBean
@RequestScoped
public class ConsulterLieuxControleur {

    private List<LieuEntity> lieux = new ArrayList<>();

    private LieuEntity lieuDetail;

    

    private LieuDAO lieuDao;
    
    public ConsulterLieuxControleur() {        
        lieuDao = new LieuDAO();
        lieux = lieuDao.findAll();

    }

    public String initialiserPage() {
        //FacesContext context = FacesContext.getCurrentInstance();

        //ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.isAuthenti}");

        return "SUCCESS";

    }
    
    public LieuEntity detailDuLieu(String index){
        return lieuDao.findById(index);
    }
    public List<LieuEntity> getLieux() {
        return lieux;
    }

    public void setLieux(List<LieuEntity> lieux) {
        this.lieux = lieux;
    }
    public LieuEntity getLieuDetail() {
        return lieuDetail;
    }

    public void setLieuDetail(LieuEntity lieuDetail) {
        this.lieuDetail = lieuDetail;
    }
}
