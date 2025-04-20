package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.SesionPK;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(Sesion.class)
public class Sesion_ { 

    public static volatile SingularAttribute<Sesion, BigInteger> horaFin;
    public static volatile SingularAttribute<Sesion, String> tipoCierre;
    public static volatile SingularAttribute<Sesion, SesionPK> sesionPK;
    public static volatile SingularAttribute<Sesion, String> iPDispositivo;
    public static volatile SingularAttribute<Sesion, String> rolNombre;

}