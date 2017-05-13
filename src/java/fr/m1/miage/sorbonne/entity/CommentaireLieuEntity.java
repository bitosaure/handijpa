/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

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
    @JoinColumn(name = "lieu")
    private LieuEntity lieu;
    
    @Id
    @JoinColumn(name = "personne")
    private PersonneEntity personne;
    
    @JoinColumn(name = "commentaire")
    private String commentaire;

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
}
