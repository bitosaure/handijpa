/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import java.util.Date;
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
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name = "AVIS")

public class AvisEntity implements Serializable {

    /**
     * SERIALVersion
     */
    private static long serialVersionUID = 1L;

    /**
     * id de l'avis, clé primaire autoincrémente
     */
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * *
     * Commentaire de l'avis que l'utilisateur
     */
    @JoinColumn(name = "commentaire")
    private String commentaire;
    /**
     * Date a laquelle l'avis a été créé
     */
    @JoinColumn(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    /**
     * Boolean permettant de savoir si l'avis est valide ou non
     */
    @JoinColumn(name = "estValide", columnDefinition = "tinyint(1)")
    private Integer estValide;

    /**
     * Lieu sur lequel l'avis a été donné
     */
    @JoinColumn(name = "lieu")
    private LieuEntity lieu;
    /**
     * Personne qui a créé l'avis
     */
    @JoinColumn(name = "createur")
    private PersonneEntity createur;

    /**
     * Retourne l'id de l'avis
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * SET L'id de l'avis
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * méthode hashCode
     *
     * @return INT
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    /**
     * méthode permettant de savoir si l'objet passé en paramètre est = à this
     *
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvisEntity)) {
            return false;
        }
        AvisEntity other = (AvisEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Retourne une chaine de caractère 
     * @return String
     */
    @Override
    public String toString() {
        return "fr.sorbonne.m1.entity.AvisEntity[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
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
     * @return the estValide
     */
    public Integer getEstValide() {
        return estValide;
    }

    /**
     * @param estValide the estValide to set
     */
    public void setEstValide(Integer estValide) {
        this.estValide = estValide;
    }

    /**
     * @return the lieu
     */
    public LieuEntity getLieu() {
        return lieu;
    }

    /**
     * 
     * 
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

}
