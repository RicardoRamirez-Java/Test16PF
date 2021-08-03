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
public class BeanPreguntas {
    public int nPregunta;
    public String pregunta ;
    public String opcion1;
     public String opcion2;
      public String opcion3;

    public BeanPreguntas(int nPregunta, String pregunta, String opcion1, String opcion2, String opcion3) {
        this.nPregunta = nPregunta;
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
    }

    public BeanPreguntas() {
    }

    public int getnPregunta() {
        return nPregunta;
    }

    public void setnPregunta(int nPregunta) {
        this.nPregunta = nPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

   
    
}
