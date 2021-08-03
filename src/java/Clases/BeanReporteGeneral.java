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
public class BeanReporteGeneral {
    public int codigo_test;
     public Date fecha ;    
     public String usuario;  
     public String nombre;

    public BeanReporteGeneral(int codigo_test, Date fecha, String usuario, String nombre) {
        this.codigo_test = codigo_test;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public BeanReporteGeneral() {
    }

    public int getCodigo_test() {
        return codigo_test;
    }

    public void setCodigo_test(int codigo_test) {
        this.codigo_test = codigo_test;
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

   
     
}
