package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ { 

    public static volatile SingularAttribute<Domicilio, String> alcaldiaMunicipio;
    public static volatile SingularAttribute<Domicilio, String> estado;
    public static volatile SingularAttribute<Domicilio, String> pacienteIDPaciente;
    public static volatile SingularAttribute<Domicilio, String> numero;
    public static volatile SingularAttribute<Domicilio, Integer> tiempoDeTraslado;
    public static volatile SingularAttribute<Domicilio, Paciente> paciente;
    public static volatile SingularAttribute<Domicilio, String> calle;
    public static volatile SingularAttribute<Domicilio, String> telefono;
    public static volatile SingularAttribute<Domicilio, String> cp;
    public static volatile SingularAttribute<Domicilio, String> colonia;

}