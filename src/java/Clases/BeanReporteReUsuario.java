/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author User
 */
public class BeanReporteReUsuario {
     public Date fecha ;    
     public String usuario;  
     public String nombre;
      public String apellido;
      public String tipoUser;
      public String detalle;

    public BeanReporteReUsuario(Date fecha, String usuario, String nombre, String apellido, String tipoUser, String detalle) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoUser = tipoUser;
        this.detalle = detalle;
    }

    public BeanReporteReUsuario() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

  
     
}
