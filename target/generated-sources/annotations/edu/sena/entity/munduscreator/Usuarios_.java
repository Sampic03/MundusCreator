package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-19T10:00:12")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> uSUNomUsu;
    public static volatile SingularAttribute<Usuarios, String> uSUNombre;
    public static volatile CollectionAttribute<Usuarios, Cursos> cursosCollection2;
    public static volatile CollectionAttribute<Usuarios, Cursos> cursosCollection1;
    public static volatile SingularAttribute<Usuarios, String> uSUFechaNac;
    public static volatile SingularAttribute<Usuarios, String> uSUApellido;
    public static volatile SingularAttribute<Usuarios, String> uSUTipodedato;
    public static volatile SingularAttribute<Usuarios, String> uSUGenero;
    public static volatile SingularAttribute<Usuarios, String> uSUCorreo;
    public static volatile CollectionAttribute<Usuarios, Cursos> cursosCollection;
    public static volatile SingularAttribute<Usuarios, String> uSUFoto;
    public static volatile SingularAttribute<Usuarios, String> uSUContrasenha;
    public static volatile CollectionAttribute<Usuarios, Roles> rolesCollection;
    public static volatile SingularAttribute<Usuarios, Integer> pKUSUId;
    public static volatile SingularAttribute<Usuarios, Short> uSUEstado;

}