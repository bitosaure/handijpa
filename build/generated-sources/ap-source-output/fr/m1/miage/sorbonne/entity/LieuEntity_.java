package fr.m1.miage.sorbonne.entity;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T14:59:45")
@StaticMetamodel(LieuEntity.class)
public class LieuEntity_ { 

    public static volatile SingularAttribute<LieuEntity, Date> dateCreation;
    public static volatile SingularAttribute<LieuEntity, CategorieEntity> categorie;
    public static volatile SingularAttribute<LieuEntity, String> adresseComplete;
    public static volatile SingularAttribute<LieuEntity, PersonneEntity> createur;
    public static volatile SingularAttribute<LieuEntity, String> description;
    public static volatile SingularAttribute<LieuEntity, Long> id;
    public static volatile SingularAttribute<LieuEntity, Integer> estValide;
    public static volatile SingularAttribute<LieuEntity, String> nom;

}