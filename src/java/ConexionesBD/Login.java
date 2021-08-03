/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ricardo Ramirez
 */
public class Login {

    Connection c = null;

    public Login() {
    }
    //METODO APRA CONFIRMAR SI EXISTE USUARIO DENTRO DE LA BASE

    public boolean existeUsuario(String usuario) {
        boolean existe = false;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select * from usuarios where usuario='" + usuario + "'  ";
            PreparedStatement p = c.prepareStatement(s);
            ResultSet rS = p.executeQuery();
            while (rS.next()) {
                existe = true;
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
        return existe;
    }

    public boolean claveCorrecta(String usuario, String clave) {
        boolean correcta = false;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select clave from usuarios where usuario='" + usuario + "' ";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

            rS.next();
            String ci = rS.getString(1);
            if (clave.equals(ci)) {
                correcta = true;
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
        return correcta;
    }

    public int getCodigoUsuario(String usuario) {
        int codigo = 0;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select codigo_usuario from usuarios where usuario='" + usuario + "'  ";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

            rS.next();
            codigo = rS.getInt(1);
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
        return codigo;
    }
    
     public int getTipoUsuario(String usuario) {
        int codigo = 0;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select tipo from usuarios where usuario='" + usuario + "'  ";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

            rS.next();
            codigo = rS.getInt(1);
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
        return codigo;
    }
     
       public int getEstadoEncuesta(String usuario) {
        int codigo = 0;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select estado from usuarios where usuario='" + usuario + "'  ";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

            rS.next();
            codigo = rS.getInt(1);
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
        return codigo;
    }
}
