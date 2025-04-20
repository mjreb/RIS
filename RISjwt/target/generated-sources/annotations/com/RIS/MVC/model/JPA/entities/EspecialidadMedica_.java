package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.Especialidad;
import com.RIS.MVC.model.JPA.entities.EspecialidadMedicaPK;
import com.RIS.MVC.model.JPA.entities.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(EspecialidadMedica.class)
public class EspecialidadMedica_ { 

    public static volatile SingularAttribute<EspecialidadMedica, String> cedulaProfesional;
    public static volatile SingularAttribute<EspecialidadMedica, EspecialidadMedicaPK> especialidadMedicaPK;
    public static volatile SingularAttribute<EspecialidadMedica, Medico> medico;
    public static volatile SingularAttribute<EspecialidadMedica, Especialidad> especialidad;

}