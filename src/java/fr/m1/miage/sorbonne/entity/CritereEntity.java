/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name = "CRITERE")
public class CritereEntity implements Serializable {

    /**
     * *
     * Serial version
     */
    private static long serialVersionUID = 1L;

    /**
     * *
     * Code qui identifie le critère de notation
     */
    @Id
    @JoinColumn(name = "code")
    private String code;

    /**
     * *
     * libelle ou nom du critere de notation
     */
    @JoinColumn(name = "libelle")
    private String libelle;

    /**
     * *
     * nombre d'etoile que la personne a donné au lieu pour ce critère *
     *
     */
    @Transient
    private Double nbEtoiles;

    /**
     * *
     * Nombre de personne qui a noté un lieu
     */
    @Transient
    private Integer nbPersonnes = 0;

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
        if (!(object instanceof CritereEntity)) {
            return false;
        }
        CritereEntity other = (CritereEntity) object;
        if ((!this.code.equals(other.code))) {
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
        return "fr.sorbonne.m1.entity.CritereEntity[ id=" + getCode() + " ]";
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
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the nbEtoiles
     */
    public Double getNbEtoiles() {
        return nbEtoiles;
    }

    /**
     * @param nbEtoiles the nbEtoiles to set
     */
    public void setNbEtoiles(Double nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    /**
     * @return the nbPersonnes
     */
    public Integer getNbPersonnes() {
        return nbPersonnes;
    }

    /**
     * @param nbPersonnes the nbPersonnes to set
     */
    public void setNbPersonnes(Integer nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

}
