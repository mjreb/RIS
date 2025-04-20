package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AgendaDeServicioPK;
import com.RIS.MVC.model.JPA.entities.EquipoImagenologia;
import com.RIS.MVC.model.JPA.entities.Medico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(AgendaDeServicio.class)
public class AgendaDeServicio_ { 

    public static volatile SingularAttribute<AgendaDeServicio, String> tipoMantenimiento;
    public static volatile SingularAttribute<AgendaDeServicio, String> estadoDeManto;
    public static volatile SingularAttribute<AgendaDeServicio, AgendaDeServicioPK> agendaDeServicioPK;
    public static volatile SingularAttribute<AgendaDeServicio, String> descrpcion;
    public static volatile SingularAttribute<AgendaDeServicio, Medico> medico;
    public static volatile SingularAttribute<AgendaDeServicio, Date> fechaControl;
    public static volatile SingularAttribute<AgendaDeServicio, EquipoImagenologia> equipoImagenologia;

}