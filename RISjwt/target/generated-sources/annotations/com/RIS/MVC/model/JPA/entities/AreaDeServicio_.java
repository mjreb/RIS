package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.Equipo;
import com.RIS.MVC.model.JPA.entities.EquipoImagenologia;
import com.RIS.MVC.model.JPA.entities.Estudio;
import com.RIS.MVC.model.JPA.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(AreaDeServicio.class)
public class AreaDeServicio_ { 

    public static volatile SingularAttribute<AreaDeServicio, String> descripcion;
    public static volatile CollectionAttribute<AreaDeServicio, EquipoImagenologia> equipoImagenologiaCollection;
    public static volatile SingularAttribute<AreaDeServicio, Integer> idArea;
    public static volatile CollectionAttribute<AreaDeServicio, Equipo> equipoCollection;
    public static volatile CollectionAttribute<AreaDeServicio, Estudio> estudioCollection;
    public static volatile CollectionAttribute<AreaDeServicio, Usuario> usuarioCollection;
    public static volatile SingularAttribute<AreaDeServicio, String> nombre;

}