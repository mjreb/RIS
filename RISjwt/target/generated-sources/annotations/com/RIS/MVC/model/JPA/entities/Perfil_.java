package com.RIS.MVC.model.JPA.entities;

import com.RIS.MVC.model.JPA.entities.PerfilPK;
import com.RIS.MVC.model.JPA.entities.Rol;
import com.RIS.MVC.model.JPA.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2025-04-19T19:24:19")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Integer> estado;
    public static volatile SingularAttribute<Perfil, PerfilPK> perfilPK;
    public static volatile SingularAttribute<Perfil, Usuario> usuario;
    public static volatile SingularAttribute<Perfil, Rol> rol;

}