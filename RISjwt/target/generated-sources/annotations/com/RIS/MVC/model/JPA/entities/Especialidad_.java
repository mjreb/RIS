package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.EspecialidadMedica;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, String> descripcion;
    public static volatile CollectionAttribute<Especialidad, EspecialidadMedica> especialidadMedicaCollection;
    public static volatile SingularAttribute<Especialidad, Integer> idEspecialidad;
    public static volatile SingularAttribute<Especialidad, String> nombre;

}