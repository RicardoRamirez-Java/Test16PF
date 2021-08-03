/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionesBD;

import Clases.BeanTipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author User
 */
public class RegistroUsuario_BD {
    Connection c = null;
    
    public RegistroUsuario_BD() {
    }
    
     public Vector getTipoUsuario() {

        Vector v=new Vector();
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select * from tipoUsuario";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

             while (rS.next())
        {   //SE LLAMA A LA CLASE  Y SE LE PASA LOS PARAMETORS OBTENIDOS DELA BASE
           BeanTipoUsuario rpv=new BeanTipoUsuario(rS.getInt(1),rS.getString(2)); 
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
     
     public boolean existeUsuario(String usuario)
   {  boolean existe=false;
     try {
          c = PollDeConexiones.getInstance().getConnection();
         String s="select * from usuarios where usuario='"+usuario+"'";
         PreparedStatement p = c.prepareStatement(s);

        ResultSet rS = p.executeQuery();

        while (rS.next())
        {     existe=true;
           }
           rS.close();
            p.close();  
     }
     catch (SQLException e) {
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
     return existe;
    }  
     
        public void registrarUsuario(String usuario, String nombre, String apellido,int tipo,String clave,int estado) {
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "insert into usuarios (fecha,usuario,nombre,apellido,tipo,clave,estado) values (CURRENT_DATE,'" + usuario + "','"+nombre+ "','"+apellido+"','"+tipo+"','"+clave+"','"+estado+"')";
            PreparedStatement p = c.prepareStatement(s);
            p.executeUpdate();
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
    }
    
}
