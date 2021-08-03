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
public class Test_RealizadoBD {

    Connection c = null;

    public Test_RealizadoBD() {

    }

    public int getCodigoDelTest() {

        int codigo = 0;
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select max(codigo_test) from testRealizados";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

            if (rS.next()) {
                codigo = rS.getInt(1) + 1;
            } else {
                codigo = 1;
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
        return codigo;
    }

    public void registrarTestRealizados(int codigoTest, int codigoUsuario) {
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "insert into testRealizados (codigo_test,fecha,codigo_usuario) values ('" + codigoTest + "',CURRENT_DATE,'" + codigoUsuario + "')";
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

    public void registrarDetalleTest(int codigoTest, int codigoPregunta, String respuesta) {
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "insert into detalleTest values ('" + codigoTest + "','" + codigoPregunta + "','" + respuesta + "')";
            PreparedStatement p = c.prepareStatement(s);
            p.executeUpdate();
            //p.close();

        } catch (SQLException e) {
            System.out.println("Database Access Error.");

        } finally { // Cierra la conexion
            if (c != null) {
                try {
                    PollDeConexiones.getInstance().closeConnection(c);
                } catch (SQLException e) {
                }
            }
        }
    }
      public void actualizaEstadoEncuesta(int estadoEncuesta, int codigoUsuario) {
        try {
             c = PollDeConexiones.getInstance().getConnection();
            String s = "update usuarios set estado='" + estadoEncuesta + "' where codigo_usuario='" + codigoUsuario + "'";
            PreparedStatement p = c.prepareStatement(s);
            System.out.println(s);
            p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Database Access Error.");
            e.printStackTrace();

        }finally { // Cierra la conexion
            if (c != null) {
                try {
                    PollDeConexiones.getInstance().closeConnection(c);
                } catch (SQLException e) {
                }
            }
        }
    }
}
