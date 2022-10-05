package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Estados;
import edu.sena.entity.munduscreator.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-04T13:21:01")
@StaticMetamodel(Mensajes.class)
public class Mensajes_ { 

    public static volatile SingularAttribute<Mensajes, Integer> pKMENId;
    public static volatile SingularAttribute<Mensajes, String> mENFecha;
    public static volatile SingularAttribute<Mensajes, Estados> fKESTId;
    public static volatile SingularAttribute<Mensajes, String> mENdescripcion;
    public static volatile SingularAttribute<Mensajes, Roles> fKROLId;

}