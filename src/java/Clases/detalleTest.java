/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Ricardo Ramirez
 */
public class detalleTest {
     public int codigoTest;    
     public int codigoPregunta;  
     public String respuesta; 

    public detalleTest(int codigoTest, int codigoPregunta, String respuesta) {
        this.codigoTest = codigoTest;
        this.codigoPregunta = codigoPregunta;
        this.respuesta = respuesta;
    }

    public detalleTest() {
    }

    public int getCodigoTest() {
        return codigoTest;
    }

    public void setCodigoTest(int codigoTest) {
        this.codigoTest = codigoTest;
    }

    public int getCodigoPregunta() {
        return codigoPregunta;
    }

    public void setCodigoPregunta(int codigoPregunta) {
        this.codigoPregunta = codigoPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

   
 

      
      
}
