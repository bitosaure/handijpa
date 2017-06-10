/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Thibault Le Grand Emilie Pisu
 */
@Entity
@Table(name = "LIEU")
public class LieuEntity implements Serializable {

    /**
     * *
     * serial Version
     */
    private static long serialVersionUID = 1L;

    /**
     * *
     * id du lieu clé primaire auto incrément
     */
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * *
     * nom du lieu
     */
    @JoinColumn(name = "nom")
    private String nom;
    /**
     * *
     * ** description du lieu
     *
     */
    @JoinColumn(name = "description")
    private String description;

    /**
     * *
     * boolean permettant de savoir si le lieu a été validé ou non par
     * l'administrateur
     */
    @JoinColumn(name = "estValide", columnDefinition = "tinyint(1)")
    private boolean estValide;

    /**
     * *
     * catégorie du lieu
     */
    @JoinColumn(name = "categorie")
    private CategorieEntity categorie;

    /**
     * *
     * personne ayant créé le lieu
     */
    @JoinColumn(name = "createur")
    private PersonneEntity createur;
    /**
     * code postal du lieu
     */
    @JoinColumn(name = "codePostal")
    private Integer codePostal;

    /**
     * *
     * numéro de rue du lieu
     *
     */
    @JoinColumn(name = "numRue")
    private Integer numRue;

    /**
     * *
     * rue du lieu
     */
    @JoinColumn(name = "rue")
    private String rue;
    /**
     * *
     * ville du lieu
     */
    @JoinColumn(name = "ville")
    private String ville;

    /**
     * *
     * telephone du lieu
     */
    @JoinColumn(name = "tel")
    private Integer tel;

    /**
     * *
     * chemin pour trouver l'image du lieu
     */
    @JoinColumn(name = "image")
    private String image;

    /**
     * *
     * pays du lieu
     */
    @JoinColumn(name = "pays")
    private String pays;

    
    /***
     * Moyenne du lieu
     */
    @Transient
    private Double moyenneDuLieu;
    /**
     * *
     * Retourne les notes du lieu
     */
    @OneToMany
    private List<NoteUnLieuEntity> notes;

    /**
     * *
     * Retourne une chaine de caractère correspond au chemin de l'image
     *
     * @return
     */
    public String cheminImage() {
        return "../../images/" + this.getImage();
    }

    /**
     * *
     * eztourne l'id du lieu
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * *
     * set the id avec le paramètre en entrée
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * *
     * Methode hashcode
     *
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
        if (!(object instanceof LieuEntity)) {
            return false;
        }
        LieuEntity other = (LieuEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
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
        return "fr.sorbonne.m1.entity.LieuEntity[ id=" + getId() + " ]";
    }

    /**
     * *
     * retourne une chaine de caractère correspond à l'adresse du lieu
     *
     * @return String
     */
    public String adresse() {
        return numRue + " " + rue + " " + codePostal + " " + ville + " " + pays;
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
    public boolean isEstValide() {
        return estValide;
    }

    /**
     * @param estValide the estValide to set
     */
    public void setEstValide(boolean estValide) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
     * @return the notes
     */
    public List<NoteUnLieuEntity> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(List<NoteUnLieuEntity> notes) {
        this.notes = notes;
    }

    /**
     * @return the moyenneDuLieu
     */
    public Double getMoyenneDuLieu() {
        return moyenneDuLieu;
    }

    /**
     * @param moyenneDuLieu the moyenneDuLieu to set
     */
    public void setMoyenneDuLieu(Double moyenneDuLieu) {
        this.moyenneDuLieu = moyenneDuLieu;
    }

}
