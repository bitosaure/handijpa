/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author emiliepisu
 */
@Entity
@Table(name = "SIGNALEMENT_COMMENTAIRE")

public class SignalementCommentaireEntity implements Serializable {

    /**
     * *
     * SERIAL version
     */
    private static final long serialVersionUID = 1L;

    /**
     * *
     * id du signalement clé primaire auto incrément
     */
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * *
     * personne qui a crée le signalement
     *
     */
    @JoinColumn(name = "createur")
    private PersonneEntity createur;

    /**
     * *
     * commentaire qui a été signalé
     */
    @JoinColumn(name = "commentaireLieu")
    private CommentaireLieuEntity commentaireLieu;

    /**
     * retourne l id du signalement
     *
     * @return long
     */
    public Long getId() {
        return id;
    }

    /**
     * set the id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * méthode hash code
     *
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * *
     * m
     *
     * @param object
     * @return boolean permettant de savoir si l instance de actuelle correspond
     * à celle passée en paraùètre
     *
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SignalementCommentaireEntity)) {
            return false;
        }
        SignalementCommentaireEntity other = (SignalementCommentaireEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Retourne une chaine de caractère
     *
     * @return String
     */
    @Override
    public String toString() {
        return "fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity[ id=" + id + " ]";
    }

    /**
     * @return the createur
     */
    public PersonneEntity getCreateur() {
        return createur;
    }

    /**
     * @param createur the createur to set
     */
    public void setCreateur(PersonneEntity createur) {
        this.createur = createur;
    }

    /**
     * @return the commentaireLieu
     */
    public CommentaireLieuEntity getCommentaireLieu() {
        return commentaireLieu;
    }

    /**
     * @param commentaireLieu the commentaireLieu to set
     */
    public void setCommentaireLieu(CommentaireLieuEntity commentaireLieu) {
        this.commentaireLieu = commentaireLieu;
    }

}
