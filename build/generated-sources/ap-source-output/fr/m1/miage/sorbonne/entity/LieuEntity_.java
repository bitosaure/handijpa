package fr.m1.miage.sorbonne.entity;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-13T12:43:08")
@StaticMetamodel(LieuEntity.class)
public class LieuEntity_ { 

    public static volatile SingularAttribute<LieuEntity, String> image;
    public static volatile SingularAttribute<LieuEntity, String> ville;
    public static volatile SingularAttribute<LieuEntity, CategorieEntity> categorie;
    public static volatile SingularAttribute<LieuEntity, String> rue;
    public static volatile SingularAttribute<LieuEntity, Integer> numRue;
    public static volatile SingularAttribute<LieuEntity, String> description;
    public static volatile SingularAttribute<LieuEntity, Boolean> estValide;
    public static volatile SingularAttribute<LieuEntity, Integer> codePostal;
    public static volatile SingularAttribute<LieuEntity, String> nom;
    public static volatile SingularAttribute<LieuEntity, PersonneEntity> createur;
    public static volatile SingularAttribute<LieuEntity, Integer> tel;
    public static volatile SingularAttribute<LieuEntity, Long> id;
    public static volatile SingularAttribute<LieuEntity, String> pays;

}