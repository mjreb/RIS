package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.ControlEstudios;
import com.RIS.MVC.model.JPA.entities.Domicilio;
import com.RIS.MVC.model.JPA.entities.SolicitudDeEstudio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> idPaciente;
    public static volatile SingularAttribute<Paciente, String> apellidoPaterno;
    public static volatile SingularAttribute<Paciente, Domicilio> domicilio;
    public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
    public static volatile CollectionAttribute<Paciente, ControlEstudios> controlEstudiosCollection;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, String> apellidoMaterno;
    public static volatile CollectionAttribute<Paciente, SolicitudDeEstudio> solicitudDeEstudioCollection;

}