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
@Table(name = "SIGNALEMENT_LIEU")
public class SignalementLieuEntity implements Serializable {

    /***
     * serial version
     */
    private static final long serialVersionUID = 1L;
    
    /***
     * id du signament
     * clé primaire
     * auto incrément
     */
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    /***
     * lieu qui a été signalé
     */
    @JoinColumn(name = "lieu")
    private LieuEntity lieu;
    /**
     * la personne qui a créé ce signalement
     */
    @JoinColumn(name = "createur")
    private PersonneEntity createur;

    /**
     * commentaire qui a été donné pour justifier le signalement
     */
    @JoinColumn(name = "commentaire")
    private String commentaire;
    
    /**
     * le type du signalement
     * ex suppression
     **/
    @JoinColumn(name = "type")
    private String type;
    /**
     * Retourne l'id
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * SET the id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * * methode hashcode
     * @return int
     * */
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
        if (!(object instanceof SignalementLieuEntity)) {
            return false;
        }
        SignalementLieuEntity other = (SignalementLieuEntity) object;
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
        return "fr.m1.miage.sorbonne.entity.SignalementLieuEntity[ id=" + id + " ]";
    }

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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
