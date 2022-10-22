package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Mensajes;
import edu.sena.entity.munduscreator.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-19T10:00:12")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> rOLNombre;
    public static volatile SingularAttribute<Roles, Integer> pKROLId;
    public static volatile CollectionAttribute<Roles, Mensajes> mensajesCollection;
    public static volatile CollectionAttribute<Roles, Usuarios> usuariosCollection;

}