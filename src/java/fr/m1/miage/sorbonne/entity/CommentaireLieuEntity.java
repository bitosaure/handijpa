/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emiliepisu
 */
@Entity
@Table(name="COMMENTAIRE_LIEU")
@Access(AccessType.FIELD)
public class CommentaireLieuEntity implements Serializable{
   private static long serialVersionUID = 1L;

     @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     @JoinColumn(name = "lieu")
    private LieuEntity lieu;
    
    @JoinColumn(name = "personne")
    private PersonneEntity personne;
    
    @JoinColumn(name = "commentaire", columnDefinition = "TEXT")
    private String commentaire;
    
    
     @JoinColumn(name = "titre")
    private String titre;
     
     
     @Temporal(TemporalType.DATE)
     @JoinColumn(name = "dateCreation")
     private Date dateCreation;

    /**
     * @return the lieu
     */
    public LieuEntity getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(LieuEntity lieu) {
        this.lieu = lieu;
    }

    /**
     * @return the personne
     */
    public PersonneEntity getPersonne() {
        return personne;
    }

    /**
     * @param personne the personne to set
     */
    public void setPersonne(PersonneEntity personne) {
        this.personne = personne;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
