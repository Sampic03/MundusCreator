package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Imagenes;
import edu.sena.entity.munduscreator.Videos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-19T10:00:12")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile CollectionAttribute<Multimedia, Imagenes> imagenesCollection;
    public static volatile SingularAttribute<Multimedia, String> mULDescripcion;
    public static volatile SingularAttribute<Multimedia, Integer> pKMULId;
    public static volatile CollectionAttribute<Multimedia, Videos> videosCollection;
    public static volatile CollectionAttribute<Multimedia, Cursos> cursosCollection;

}