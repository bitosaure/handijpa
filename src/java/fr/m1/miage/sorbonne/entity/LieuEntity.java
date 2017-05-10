/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name = "LIEU")
public class LieuEntity implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "nom")
    private String nom;

    @JoinColumn(name = "description")
    private String description;
    
    @JoinColumn(name = "estValide",  columnDefinition="tinyint(1)")
    private Integer estValide;
    @JoinColumn(name = "categorie")
    @OneToOne(cascade = CascadeType.ALL)
    private CategorieEntity categorie;

    @JoinColumn(name = "createur")
    @OneToOne(cascade = CascadeType.ALL)
    private PersonneEntity createur;
    @JoinColumn(name="codePostal")
    private Integer codePostal;
    @JoinColumn(name="numRue")
    private Integer numRue;
    @JoinColumn(name="rue")
    private String rue;
    @JoinColumn(name="ville")
    private String ville;
    @JoinColumn(name="tel")
    private Integer tel;
    @JoinColumn(name="pays")
    private String pays;
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
        if (!(object instanceof LieuEntity)) {
            return false;
        }
        LieuEntity other = (LieuEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.sorbonne.m1.entity.LieuEntity[ id=" + getId() + " ]";
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }



    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

  

    /**
     * @return the estValide
     */
    public Integer isEstValide() {
        return estValide;
    }

    /**
     * @param estValide the estValide to set
     */
    public void setEstValide(Integer estValide) {
        this.estValide = estValide;
    }

    /**
     * @return the categorie
     */
    public CategorieEntity getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
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
     * @return the codePostal
     */
    public Integer getCodePostal() {
        return codePostal;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * @return the numRue
     */
    public Integer getNumRue() {
        return numRue;
    }

    /**
     * @param numRue the numRue to set
     */
    public void setNumRue(Integer numRue) {
        this.numRue = numRue;
    }

    /**
     * @return the rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * @param rue the rue to set
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the tel
     */
    public Integer getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(Integer tel) {
        this.tel = tel;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

}
