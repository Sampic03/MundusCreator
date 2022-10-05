package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-04T13:21:01")
@StaticMetamodel(Videos.class)
public class Videos_ { 

    public static volatile SingularAttribute<Videos, Integer> pKVIDId;
    public static volatile SingularAttribute<Videos, String> vIDDescripcion;
    public static volatile SingularAttribute<Videos, String> vIDRutaVideo;
    public static volatile CollectionAttribute<Videos, Multimedia> multimediaCollection;

}