package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AreaDeServicio;
import com.RIS.MVC.model.JPA.entities.AsignacionEstudio;
import com.RIS.MVC.model.JPA.entities.ControlEstudios;
import com.RIS.MVC.model.JPA.entities.ProtocoloEstudio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(Estudio.class)
public class Estudio_ { 

    public static volatile SingularAttribute<Estudio, String> descripcion;
    public static volatile CollectionAttribute<Estudio, ProtocoloEstudio> protocoloEstudioCollection;
    public static volatile SingularAttribute<Estudio, AreaDeServicio> areaDeServicioidArea;
    public static volatile CollectionAttribute<Estudio, ControlEstudios> controlEstudiosCollection;
    public static volatile SingularAttribute<Estudio, Integer> idEstudio;
    public static volatile SingularAttribute<Estudio, String> nombre;
    public static volatile CollectionAttribute<Estudio, AsignacionEstudio> asignacionEstudioCollection;

}