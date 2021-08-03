/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionesBD;

import Clases.BeanPreguntas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author User
 */
public class Preguntas {
    Connection c = null;

    public Preguntas() {
    }
    
     public Vector getPreguntas() {

        Vector v=new Vector();
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "SELECT * FROM public.preguntas ORDER BY codigo ASC ";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

             while (rS.next())
        {   //SE LLAMA A LA CLASE  Y SE LE PASA LOS PARAMETORS OBTENIDOS DELA BASE
           BeanPreguntas rpv=new BeanPreguntas(rS.getInt(1),rS.getString(2),rS.getString(3),rS.getString(4),rS.getString(5)); 
           v.addElement(rpv);
           
        }

            rS.close();
            p.close();

        } catch (SQLException e) {
            System.out.println("Database Access Error.");
            e.printStackTrace();
        } finally { // Cierra la conexion
            if (c != null) {
                try {
                    PollDeConexiones.getInstance().closeConnection(c);
                } catch (SQLException e) {
                }
            }
        }
        return v;
    }
}
