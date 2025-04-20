package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.AreaDeServicio;
import com.RIS.MVC.model.JPA.entities.ControlEstudios;
import com.RIS.MVC.model.JPA.entities.Perfil;
import com.RIS.MVC.model.JPA.entities.UsuarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T16:32:21")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Perfil> perfilCollection;
    public static volatile SingularAttribute<Usuario, String> apellidoPaterno;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> passwd;
    public static volatile SingularAttribute<Usuario, AreaDeServicio> areaidArea;
    public static volatile CollectionAttribute<Usuario, ControlEstudios> controlEstudiosCollection;
    public static volatile SingularAttribute<Usuario, UsuarioPK> usuarioPK;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> usuarioID;
    public static volatile SingularAttribute<Usuario, String> apellidoMaterno;

}