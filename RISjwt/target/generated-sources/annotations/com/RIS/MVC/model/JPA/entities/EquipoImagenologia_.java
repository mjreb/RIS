package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AgendaDeServicio;
import com.RIS.MVC.model.JPA.entities.AreaDeServicio;
import com.RIS.MVC.model.JPA.entities.AsignacionEstudio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(EquipoImagenologia.class)
public class EquipoImagenologia_ { 

    public static volatile SingularAttribute<EquipoImagenologia, String> marca;
    public static volatile SingularAttribute<EquipoImagenologia, String> estado;
    public static volatile SingularAttribute<EquipoImagenologia, AreaDeServicio> areaDeServicioidArea;
    public static volatile CollectionAttribute<EquipoImagenologia, AgendaDeServicio> agendaDeServicioCollection;
    public static volatile SingularAttribute<EquipoImagenologia, String> modalidad;
    public static volatile SingularAttribute<EquipoImagenologia, String> nSerie;
    public static volatile SingularAttribute<EquipoImagenologia, String> nombre;
    public static volatile SingularAttribute<EquipoImagenologia, String> modelo;
    public static volatile CollectionAttribute<EquipoImagenologia, AsignacionEstudio> asignacionEstudioCollection;
    public static volatile SingularAttribute<EquipoImagenologia, Date> fechaInstalacion;

}