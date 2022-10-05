package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import edu.sena.entity.munduscreator.Papeleria;
import edu.sena.entity.munduscreator.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-04T13:21:02")
@StaticMetamodel(Cursos.class)
public class Cursos_ { 

    public static volatile SingularAttribute<Cursos, Multimedia> fKMULId;
    public static volatile SingularAttribute<Cursos, String> curImagen;
    public static volatile SingularAttribute<Cursos, String> cURnombre;
    public static volatile CollectionAttribute<Cursos, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Cursos, Papeleria> fKPAPId;
    public static volatile SingularAttribute<Cursos, String> cURDescripcion;
    public static volatile CollectionAttribute<Cursos, Usuarios> usuariosCollection1;
    public static volatile SingularAttribute<Cursos, Integer> pKCURId;
    public static volatile SingularAttribute<Cursos, String> cURFechaCreacion;
    public static volatile CollectionAttribute<Cursos, Usuarios> usuariosCollection2;

}