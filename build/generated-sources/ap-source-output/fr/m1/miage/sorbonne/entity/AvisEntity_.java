package fr.m1.miage.sorbonne.entity;

import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T14:59:45")
@StaticMetamodel(AvisEntity.class)
public class AvisEntity_ { 

    public static volatile SingularAttribute<AvisEntity, Date> dateCreation;
    public static volatile SingularAttribute<AvisEntity, PersonneEntity> createur;
    public static volatile SingularAttribute<AvisEntity, Long> id;
    public static volatile SingularAttribute<AvisEntity, Integer> estValide;
    public static volatile SingularAttribute<AvisEntity, String> commentaire;
    public static volatile SingularAttribute<AvisEntity, LieuEntity> lieu;

}