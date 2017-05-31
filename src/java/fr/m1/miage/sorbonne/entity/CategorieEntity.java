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
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name="CATEGORIE")
@Access(AccessType.FIELD)
public class CategorieEntity implements Serializable {
    /***
     * SerialVersion
     */
    private static long serialVersionUID = 1L;
    /***
     * code de la catégorie, est une clef primaire 
     */
    @Id
    @JoinColumn(name = "code")
    private String code;
    /**
     * LIBELLE DE la catégorie
     */
    @JoinColumn(name="libelle")
    private String libelle;
    
    
    /**
     * méthode hashCode
     *
     * @return INT
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getCode() != null ? getCode().hashCode() : 0);
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
        if (!(object instanceof CategorieEntity)) {
            return false;
        }
        CategorieEntity other = (CategorieEntity) object;
        if ((this.getCode() == null && other.getCode() != null) || (this.getCode() != null && !this.code.equals(other.code))) {
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
        return this.libelle;
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

}
