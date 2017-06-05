/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.controleur;

import fr.m1.miage.sorbonne.dao.CommentaireLieuDAO;
import fr.m1.miage.sorbonne.dao.CritereDAO;
import fr.m1.miage.sorbonne.dao.LieuDAO;
import fr.m1.miage.sorbonne.dao.SignalementCommentaireDAO;
import fr.m1.miage.sorbonne.dao.SignalementLieuDAO;
import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
import fr.m1.miage.sorbonne.entity.CritereEntity;
import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
import fr.m1.miage.sorbonne.entity.SignalementLieuEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 *
 * @author thibault
 */
@ManagedBean
@SessionScoped
public class ConsulterLieuxControleur implements Serializable {

    /**
     * *
     * Liste de tous les lieux présents dans la base de données
     */
    private List<LieuEntity> lieux = new ArrayList<>();

    /**
     * *
     * lieu que l'on souhaite consulter
     */
    private LieuEntity lieuDetail;

    /**
     * DAO permettant d'agir sur la table lieu présente dans la base de données
     */
    private LieuDAO lieuDao;

    /**
     * Liste des critères applicables à des lieux
     */
    private List<CritereEntity> listCritere = new ArrayList<CritereEntity>();

    /**
     * *
     * Liste des commentaires sur le lieu consulté
     */
    private List<CommentaireLieuEntity> listCommentaires = new ArrayList<CommentaireLieuEntity>();

    /**
     * DAO permettant d'agir sur la table COMMENTAIRE présente dans la base de
     * données
     */
    private CommentaireLieuDAO commentaireDAO;

    /**
     * Commentaire que l'on souhaite créér concernant le lieu consulté
     */
    private CommentaireLieuEntity commentaire = new CommentaireLieuEntity();

    /**
     * Liste des moyennes des critères sur le lieu consulté
     */
    private List<CritereEntity> listCriterLieuDetailMoyenne = new ArrayList<CritereEntity>();

    /**
     * Signalement du lieu choisi qui peut être une suppression ou une
     * modification
     */
    private SignalementLieuEntity signalementLieu = new SignalementLieuEntity();

    /**
     * *
     * Constructeur de la classe
     */
    public ConsulterLieuxControleur() {
        lieuDao = new LieuDAO();
        lieux = lieuDao.findValider();

    }

    /**
     * Constructeur prenant la liste des critere entity en paramètre
     *
     * @param listC de type List<CritereEntity>
     */
    public ConsulterLieuxControleur(List<CritereEntity> listC) {
        listCriterLieuDetailMoyenne = listC;
    }

    /**
     * Méthode appelée lorsque l'on souhaite consulter la page consulterLieux
     *
     * @return String : pour savoir si un problème est apparu ou non
     */
    public String initialiserPage() {
        setCommentaire(new CommentaireLieuEntity());
        CritereDAO critereDao = new CritereDAO();
        setListCritere(critereDao.findAll());
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        PersonneEntity pers = (PersonneEntity) binding.getValue(context);
        commentaire.setPersonne(pers);
        //FacesContext context = FacesContext.getCurrentInstance();
        commentaireDAO = new CommentaireLieuDAO();
        lieuDao = new LieuDAO();
        lieux = lieuDao.findValider();
        this.lieuDetail = null;
        //ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.isAuthenti}");
        return "SUCCESS";

    }

    /**
     * Methode permettant d'ajouter un commentaire au lieu consulté
     */
    public void ajouterCommentaire() {

        commentaire.setPersonne(recuperationPersonneConnectée());
        commentaireDAO = new CommentaireLieuDAO();
        commentaire.setLieu(lieuDetail);
        commentaire.setDateCreation(new Date());
        commentaireDAO.create(commentaire);

        listCommentaires.add(commentaire);
        commentaire = new CommentaireLieuEntity();

        FacesMessage message = new FacesMessage("nous avons bien intégré votre commentaire");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /**
     * Methode permettant de récupérer la personne connectée
     *
     * @return PersonneEntity
     */
    private PersonneEntity recuperationPersonneConnectée() {
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{authentificationControleur.personne}");
        return (PersonneEntity) binding.getValue(context);
    }

    /**
     * méthode permerttant de signaler un commentaire sur le lieu consulté
     *
     * @param comm De type CommentaireLieuEntity qui est le commentaire que
     * l'utilisateur souhaite signalé
     */
    public void signalerCommentaire(CommentaireLieuEntity comm) {

        SignalementCommentaireEntity signalement = new SignalementCommentaireEntity();
        PersonneEntity pers = recuperationPersonneConnectée();
        if (pers.getId() == null) {
            FacesMessage message = new FacesMessage("Pour signaler un commentaire, veuillez vous authentifier");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            signalement.setCreateur(pers);
            signalement.setCommentaireLieu(comm);
            SignalementCommentaireDAO signDAO = new SignalementCommentaireDAO();
            signDAO.create(signalement);
        }

    }

    /**
     * Méthode permettant de récupérer l"id du lieu consulter
     *
     * @return string correspond à l'id du lieu que l'utilisateur souhaite
     * consulter
     */
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

    /**
     * Méthode permettant de consulter le lieu que l'on souhaite
     *
     * @param lieu de type LieuEntity, lieu que l'on souhaite consutler
     */
    public void setLieuDetail(LieuEntity lieu) {
        this.lieuDetail = lieu;
        //listeBd.get(i).setImage("./images/"+listeBd.get(i).getImage());
        listCommentaires = commentaireDAO.rechercherCommentaireLieu(lieuDetail);

        actualiserNote();

        // html = (HtmlInputText) ui.findComponent("consulterLieux:secret");
    }

    /**
     * *
     * Methode permettant de signaler le lieu que l'utilisateur consulte
     */
    public void signalerLieu() {
        signalementLieu.setCreateur(recuperationPersonneConnectée());

        signalementLieu.setLieu(lieuDetail);
        SignalementLieuDAO signalementDao = new SignalementLieuDAO();
        signalementDao.create(signalementLieu);
        signalementLieu = new SignalementLieuEntity();
    }

    /**
     * *
     * Methode permettant à l'utilisateur de noter le lieu
     */
    public void noterLieu() {

        PersonneEntity pers = recuperationPersonneConnectée();

        NoteUnLieuEntity note;
        for (CritereEntity criter : listCritere) {
            note = new NoteUnLieuEntity();
            note.setCritere(criter);
            note.setPersonne(pers);
            note.setNombreEtoile(criter.getNbEtoiles());
            lieuDetail.getNotes().add(note);

        }
        LieuDAO lieDao = new LieuDAO();
        lieDao.update(lieuDetail);
        CritereDAO critereDao = new CritereDAO();
        setListCritere(critereDao.findAll());

        actualiserNote();

    }

    /**
     * *
     * Methode permettant d'actualiser les notes du lieu
     */
    private void actualiserNote() {
        CritereDAO critereDao = new CritereDAO();
        setListCriterLieuDetailMoyenne(critereDao.findAll());
        recupererLesNotes();

        noterSur5LesCritere();

    }

    private void recupererLesNotes() {
        int j;

        for (int i = 0; i < getListCriterLieuDetailMoyenne().size(); i++) {

            getListCriterLieuDetailMoyenne().get(i).setNbEtoiles(0.0);
            getListCriterLieuDetailMoyenne().get(i).setNbPersonnes(0);
        }
        for (NoteUnLieuEntity note : lieuDetail.getNotes()) {

            j = getListCriterLieuDetailMoyenne().indexOf(note.getCritere());
            getListCriterLieuDetailMoyenne().get(j).setNbEtoiles(getListCriterLieuDetailMoyenne().get(j).getNbEtoiles() + note.getNombreEtoile());
            getListCriterLieuDetailMoyenne().get(j).setNbPersonnes(getListCriterLieuDetailMoyenne().get(j).getNbPersonnes() + 1);
        }
    }

    /**
     *
     * méthode permettant de mettre les notes sur 5
     */
    public List<CritereEntity> noterSur5LesCritere() {
        for (CritereEntity obj : getListCriterLieuDetailMoyenne()) {
            if (obj.getNbPersonnes() != 0) {

                obj.setNbEtoiles((double) Math.round(obj.getNbEtoiles() / obj.getNbPersonnes() * 100) / 100);

            } else {
                obj.setNbEtoiles(null);
            }
        }
        return getListCriterLieuDetailMoyenne();
    }

    /**
     * retourne le commentaire que l'utilisateur a créé
     *
     * @return the commentaire de type CommentaireLieuEntity
     */
    public CommentaireLieuEntity getCommentaire() {
        return commentaire;
    }

    /**
     * set the commentaire de type CommentaireLieuEntity
     *
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(CommentaireLieuEntity commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * retourne la liste des commentaires du lieu
     *
     * @return the listCommentaires de type List<CommentaireLieuEntity>
     */
    public List<CommentaireLieuEntity> getListCommentaires() {
        return listCommentaires;
    }

    /**
     * set the liste des commentaires
     *
     * @param listCommentaires the listCommentaires to set
     */
    public void setListCommentaires(List<CommentaireLieuEntity> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    /**
     * retourne la liste des différents critères de note
     *
     * @return the listCritere
     */
    public List<CritereEntity> getListCritere() {
        return listCritere;
    }

    /**
     * set listCritere
     *
     * @param listCritere the listCritere to set
     */
    public void setListCritere(List<CritereEntity> listCritere) {
        this.listCritere = listCritere;
    }

    /**
     * retourne la liste des notes du lieu
     *
     * @return the listCriterLieuDetailMoyenne
     */
    public List<CritereEntity> getListCriterLieuDetailMoyenne() {
        return listCriterLieuDetailMoyenne;
    }

    /**
     * modifie la liste des critères du lieu
     *
     * @param listCriterLieuDetailMoyenne the listCriterLieuDetailMoyenne to set
     */
    public void setListCriterLieuDetailMoyenne(List<CritereEntity> listCriterLieuDetailMoyenne) {
        this.listCriterLieuDetailMoyenne = listCriterLieuDetailMoyenne;
    }

    public List<LieuEntity> getLieux() {
        return lieux;
    }

    /**
     * set la liste des lieux
     *
     * @param lieux
     */
    public void setLieux(List<LieuEntity> lieux) {
        this.lieux = lieux;
    }

    /**
     * retoutne le lieu consulté
     *
     * @return LieuEntity
     */
    public LieuEntity getLieuDetail() {
        return lieuDetail;
    }

    /**
     * retourne le signalement du lieu consulté que l'utilisateur a créé
     *
     * @return the signalementLieu
     */
    public SignalementLieuEntity getSignalementLieu() {
        return signalementLieu;
    }

    /**
     * set le signalement du lieu créé par l'utilisateur
     *
     * @param signalementLieu the signalementLieu to set
     */
    public void setSignalementLieu(SignalementLieuEntity signalementLieu) {
        this.signalementLieu = signalementLieu;
    }
}
