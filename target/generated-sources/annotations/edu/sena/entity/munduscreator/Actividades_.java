package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-19T10:00:12")
@StaticMetamodel(Actividades.class)
public class Actividades_ { 

    public static volatile SingularAttribute<Actividades, String> aCTRuta;
    public static volatile SingularAttribute<Actividades, String> aCTNombre;
    public static volatile SingularAttribute<Actividades, Integer> pKACTId;
    public static volatile CollectionAttribute<Actividades, Papeleria> papeleriaCollection;
    public static volatile SingularAttribute<Actividades, String> aCTDescripcion;

}