/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.CommentaireLieuDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 *
 * @author thibault
 */
@ManagedBean
@SessionScoped
public class ConsulterLieuxControleur implements Serializable{

    private List<LieuEntity> lieux = new ArrayList<>();

    private LieuEntity lieuDetail;

    private String code = "";
    private LieuDAO lieuDao;

    private List<CommentaireLieuEntity> listCommentaires =new ArrayList<CommentaireLieuEntity>();

    private CommentaireLieuDAO commentaireDAO;
    private CommentaireLieuEntity commentaire= new CommentaireLieuEntity();

    public ConsulterLieuxControleur() {
        lieuDao = new LieuDAO();
        lieux = lieuDao.findValider();
        

    }

    public String initialiserPage() {
           setCommentaire(new CommentaireLieuEntity());

        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        commentaire.setPersonne(pers);
        //FacesContext context = FacesContext.getCurrentInstance();

        //ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.isAuthenti}");
        return "SUCCESS";

    }

    public void ajouterCommentaire() {
        commentaireDAO = new CommentaireLieuDAO();
              FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        commentaire.setPersonne(pers);
        
        
        commentaire.setLieu(lieuDetail);
        commentaire.setDateCreation(new Date());
        commentaireDAO.create(commentaire);
        FacesMessage message = new FacesMessage("nous avons bien intégré votre commentaire");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public LieuEntity detailDuLieu(String index) {
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

    public String recupId() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot ui = context.getViewRoot();

        HtmlInputText html = (HtmlInputText) ui.findComponent("consulterLieux:secret");
        if (html == null) {
            System.out.println("element null");
        }
        Map<String, Object> map = html.getAttributes();

        System.out.println(html.getValue().toString());
        return html.getValue().toString();
    }

    public void setLieuDetail(LieuEntity lieu) {
        this.lieuDetail = lieu;
        commentaireDAO = new CommentaireLieuDAO();
        //listeBd.get(i).setImage("./images/"+listeBd.get(i).getImage());
         listCommentaires =commentaireDAO.rechercherCommentaireLieu(lieuDetail);
        System.out.println(lieuDetail.adresse());
        
        
    }

    public void setLieuDetail() {
        String id = recupId();
        System.out.println(recupId());
        System.out.println("id entrée " + id);
        //Long idd = Long.parseLong(id);
        lieuDetail = lieuDao.findById(id);
        System.out.println("nom lieu " + lieuDetail.getNom());

    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the commentaire
     */
    public CommentaireLieuEntity getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(CommentaireLieuEntity commentaire) {
       this.commentaire=commentaire;
    }

    /**
     * @return the listCommentaires
     */
    public List<CommentaireLieuEntity> getListCommentaires() {
        return listCommentaires;
    }

    /**
     * @param listCommentaires the listCommentaires to set
     */
    public void setListCommentaires(List<CommentaireLieuEntity> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

   
}
