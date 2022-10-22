package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-19T10:00:12")
@StaticMetamodel(Evaluaciones.class)
public class Evaluaciones_ { 

    public static volatile SingularAttribute<Evaluaciones, String> eVARuta;
    public static volatile SingularAttribute<Evaluaciones, Integer> pKEVAId;
    public static volatile SingularAttribute<Evaluaciones, String> eVANombre;
    public static volatile SingularAttribute<Evaluaciones, String> eVADescripcion;
    public static volatile CollectionAttribute<Evaluaciones, Papeleria> papeleriaCollection;

}