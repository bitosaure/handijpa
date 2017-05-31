/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thibault Le Grand Emilie Pisu
 */
@Table(name = "NoteUnLieu")
@Entity
public class NoteUnLieuEntity implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "nombreEtoile")
    private Double nombreEtoile;


    @JoinColumn(name = "personne")
    private PersonneEntity personne;

    @JoinColumn(name = "critere")
    private CritereEntity critere;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteUnLieuEntity)) {
            return false;
        }
        NoteUnLieuEntity other = (NoteUnLieuEntity) object;
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
        return "fr.sorbonne.m1.entity.NoteUnLieuEntity[ id=" + getId() + " ]";
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
     * @return the nombreEtoile
     */
    public Double getNombreEtoile() {
        return nombreEtoile;
    }

    /**
     * @param nombreEtoile the nombreEtoile to set
     */
    public void setNombreEtoile(Double nombreEtoile) {
        this.nombreEtoile = nombreEtoile;
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
     * @return the critere
     */
    public CritereEntity getCritere() {
        return critere;
    }

    /**
     * @param critere the critere to set
     */
    public void setCritere(CritereEntity critere) {
        this.critere = critere;
    }

}
