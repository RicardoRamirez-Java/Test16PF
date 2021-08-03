/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author User
 */
public class BeanTipoUsuario {
       public int codigoTipo;    
     public String nombre;  

    public BeanTipoUsuario(int codigoTipo, String nombre) {
        this.codigoTipo = codigoTipo;
        this.nombre = nombre;
    }

    public BeanTipoUsuario() {
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
}
