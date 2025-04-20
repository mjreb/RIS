package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AsignacionEstudioPK;
import com.RIS.MVC.model.JPA.entities.EquipoImagenologia;
import com.RIS.MVC.model.JPA.entities.Estudio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(AsignacionEstudio.class)
public class AsignacionEstudio_ { 

    public static volatile SingularAttribute<AsignacionEstudio, Date> fecha;
    public static volatile SingularAttribute<AsignacionEstudio, AsignacionEstudioPK> asignacionEstudioPK;
    public static volatile SingularAttribute<AsignacionEstudio, Estudio> estudio;
    public static volatile SingularAttribute<AsignacionEstudio, EquipoImagenologia> equipoImagenologia;

}