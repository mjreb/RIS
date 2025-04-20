package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AgendaDeServicio;
import com.RIS.MVC.model.JPA.entities.EspecialidadMedica;
import com.RIS.MVC.model.JPA.entities.MedicoPK;
import com.RIS.MVC.model.JPA.entities.SolicitudDeEstudio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, MedicoPK> medicoPK;
    public static volatile CollectionAttribute<Medico, AgendaDeServicio> agendaDeServicioCollection;
    public static volatile CollectionAttribute<Medico, EspecialidadMedica> especialidadMedicaCollection;
    public static volatile CollectionAttribute<Medico, SolicitudDeEstudio> solicitudDeEstudioCollection;

}