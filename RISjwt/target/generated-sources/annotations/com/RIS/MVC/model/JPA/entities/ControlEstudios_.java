package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.ControlEstudiosPK;
import com.RIS.MVC.model.JPA.entities.Estudio;
import com.RIS.MVC.model.JPA.entities.Paciente;
import com.RIS.MVC.model.JPA.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(ControlEstudios.class)
public class ControlEstudios_ { 

    public static volatile SingularAttribute<ControlEstudios, String> estado;
    public static volatile SingularAttribute<ControlEstudios, Boolean> cerrado;
    public static volatile SingularAttribute<ControlEstudios, Paciente> paciente;
    public static volatile SingularAttribute<ControlEstudios, Estudio> estudio;
    public static volatile SingularAttribute<ControlEstudios, Date> fechaControl;
    public static volatile SingularAttribute<ControlEstudios, String> observaciones;
    public static volatile SingularAttribute<ControlEstudios, Usuario> usuario;
    public static volatile SingularAttribute<ControlEstudios, ControlEstudiosPK> controlEstudiosPK;

}