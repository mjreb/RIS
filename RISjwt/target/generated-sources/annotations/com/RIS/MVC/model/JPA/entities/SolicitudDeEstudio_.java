package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.Medico;
import com.RIS.MVC.model.JPA.entities.Paciente;
import com.RIS.MVC.model.JPA.entities.SolicitudDeEstudioPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(SolicitudDeEstudio.class)
public class SolicitudDeEstudio_ { 

    public static volatile SingularAttribute<SolicitudDeEstudio, String> areaProcedencia;
    public static volatile SingularAttribute<SolicitudDeEstudio, Date> fechaProximaCita;
    public static volatile SingularAttribute<SolicitudDeEstudio, String> estado;
    public static volatile SingularAttribute<SolicitudDeEstudio, Date> fechaSolicitud;
    public static volatile SingularAttribute<SolicitudDeEstudio, SolicitudDeEstudioPK> solicitudDeEstudioPK;
    public static volatile SingularAttribute<SolicitudDeEstudio, String> diagnostico;
    public static volatile SingularAttribute<SolicitudDeEstudio, Paciente> paciente;
    public static volatile SingularAttribute<SolicitudDeEstudio, Medico> medico;
    public static volatile SingularAttribute<SolicitudDeEstudio, String> observaciones;

}