/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import static com.sun.faces.facelets.util.Path.context;
import fr.m1.miage.sorbonne.dao.CategorieDAO;
import fr.m1.miage.sorbonne.dao.CommentaireLieuDAO;
import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.SignalementCommentaireDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
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
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author thibault
 */
@ManagedBean
@SessionScoped
public class ConsulterLieuxControleur implements Serializable {

    private List<LieuEntity> lieux = new ArrayList<>();

    private LieuEntity lieuDetail;

    private String code = "";
    private LieuDAO lieuDao;

    private List<CritereEntity> listCritere = new ArrayList<CritereEntity>();
    private List<CommentaireLieuEntity> listCommentaires = new ArrayList<CommentaireLieuEntity>();

    private CommentaireLieuDAO commentaireDAO;
    private CommentaireLieuEntity commentaire = new CommentaireLieuEntity();

    public ConsulterLieuxControleur() {
        lieuDao = new LieuDAO();
        lieux = lieuDao.findValider();

    }

    public String initialiserPage() {
        setCommentaire(new CommentaireLieuEntity());
        CritereDAO critereDao = new CritereDAO();
        setListCritere(critereDao.findAll());
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        commentaire.setPersonne(pers);
        //FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("pers: " + pers.getTypePersonne());

        this.lieuDetail = null;
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

        commentaire = new CommentaireLieuEntity();
        listCommentaires.add(commentaire);
        FacesMessage message = new FacesMessage("nous avons bien intégré votre commentaire");
        FacesContext.getCurrentInstance().addMessage(null, message);

        System.out.println("toto");

    }

    public void signalerCommentaire(CommentaireLieuEntity comm) {
        System.out.println("totonnn");

        FacesContext context = FacesContext.getCurrentInstance();

        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        SignalementCommentaireEntity signalement = new SignalementCommentaireEntity();
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        if (pers.getId() == null) {
            FacesMessage message = new FacesMessage("Pour signaler un commentaire, veuillez vous authentifier");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            signalement.setCreateur(pers);
            signalement.setCommentaireLieu(comm);
            SignalementCommentaireDAO signDAO = new SignalementCommentaireDAO();
            signDAO.create(signalement);
        }

        System.out.println("signaler");
        
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
        listCommentaires = commentaireDAO.rechercherCommentaireLieu(lieuDetail);
        System.out.println(lieuDetail.adresse());
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot ui = context.getViewRoot();

        // html = (HtmlInputText) ui.findComponent("consulterLieux:secret");
    }

    public void setLieuDetail() {
        String id = recupId();
        System.out.println(recupId());
        System.out.println("id entrée " + id);
        //Long idd = Long.parseLong(id);
        lieuDetail = lieuDao.findById(id);
        System.out.println("nom lieu " + lieuDetail.getNom());

    }

    public void noterLieu() {
        FacesContext context = FacesContext.getCurrentInstance();

        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        SignalementCommentaireEntity signalement = new SignalementCommentaireEntity();
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        if (pers.getId() == null) {
            FacesMessage message = new FacesMessage("Pour noter un lieu, veuillez vous authentifier");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            NoteUnLieuEntity note;
            for (CritereEntity criter : listCritere) {
                note = new NoteUnLieuEntity();
               note.setCritere(criter);
               note.setPersonne(pers);
               System.out.println(criter.getNbEtoiles().toString());
               note.setNombreEtoile(criter.getNbEtoiles());
               lieuDetail.getNotes().add(note);
              
            }
            LieuDAO lieDao = new LieuDAO();
            lieDao.update(lieuDetail);
            CritereDAO critereDao = new CritereDAO();
        setListCritere(critereDao.findAll());
            

        }

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
        this.commentaire = commentaire;
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

    /**
     * @return the listCritere
     */
    public List<CritereEntity> getListCritere() {
        return listCritere;
    }

    /**
     * @param listCritere the listCritere to set
     */
    public void setListCritere(List<CritereEntity> listCritere) {
        this.listCritere = listCritere;
    }
}
