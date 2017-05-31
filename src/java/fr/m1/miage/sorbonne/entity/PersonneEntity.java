/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name="PERSONNE")
public class PersonneEntity implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @JoinColumn(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name="nom")
    private String nom;
    @JoinColumn(name="prenom")
    private String prenom;
    @JoinColumn(name="login")
    private String login;
    @JoinColumn(name="mdp")
    private String mdp;
    @JoinColumn(name="mail")
    private String mail;
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
    @JoinColumn(name="typePersonne")
    private String typePersonne;

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
        if (!(object instanceof PersonneEntity)) {
            return false;
        }
        PersonneEntity other = (PersonneEntity) object;
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
        return "fr.sorbonne.m1.entity.PersonneEntity[ id=" + getId() + " ]";
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
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

    /**
     * @return the typePersonne
     */
    public String getTypePersonne() {
        return typePersonne;
    }

    /**
     * @param typePersonne the typePersonne to set
     */
    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }

}
