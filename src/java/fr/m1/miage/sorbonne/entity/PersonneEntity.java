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
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name="PERSONNE")
public class PersonneEntity implements Serializable {
    /***
     * SERial versions
     */
    private static long serialVersionUID = 1L;
    
    /**
     * * id de la personne
     * clé primaire
     * auto incrémente
     * */
    @Id
    @JoinColumn(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    /**
     * Nom de la personne
     */
    @JoinColumn(name="nom")
    private String nom;
    /***
     * prenom de la personne
     */
    @JoinColumn(name="prenom")
    private String prenom;
    
    /***
     * login de la personne
     */
    @JoinColumn(name="login")
    private String login;
    
    /***
     * mot de passe de la personne
     */
    @JoinColumn(name="mdp")
    private String mdp;
    
    
    /**
     * email de la personne
     */
    @JoinColumn(name="mail")
    private String mail;
    
    /***
     * * code postal de la personne
     * */
    @JoinColumn(name="codePostal")
    private Integer codePostal;
    
    /**
     * numéro de rue de la personne
     */
    @JoinColumn(name="numRue")
    private Integer numRue;
    
    /**
     * rue de la personne
     */
    @JoinColumn(name="rue")
    private String rue;
    
    /**
     * ville de la personne
     */
    @JoinColumn(name="ville")
    private String ville;
    
    /**
     * telephone de la personne
     */
    @JoinColumn(name="tel")
    private Integer tel;
    /**
     * pays auquel apparatient la personne
     */
    @JoinColumn(name="pays")
    private String pays;
    
    /**
     * TYPE DE LA PERSONNE
     * par exemple, admin ou lambda
    **/
    @JoinColumn(name="typePersonne")
    private String typePersonne;

    
    /**
     * retourne l'id de la personne
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * set l id de la personne
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * hash code 
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
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
