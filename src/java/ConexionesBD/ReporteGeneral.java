
package ConexionesBD;

import Clases.BeanReporteGeneral;
import Clases.BeanReporteReUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class ReporteGeneral {
  Connection c = null;
  
    public ReporteGeneral() {
    }
    //metodo crud con bean para generar reporte 
    public Vector getReporteGeneral() {

        Vector v=new Vector();
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select t.codigo_test, t.fecha,u.usuario,u.nombre from testrealizados as t inner join usuarios as u on t.codigo_usuario=u.codigo_usuario";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

             while (rS.next())
        {   //SE LLAMA A LA CLASE  Y SE LE PASA LOS PARAMETORS OBTENIDOS DELA BASE
           BeanReporteGeneral rpv=new BeanReporteGeneral(rS.getInt(1), rS.getDate(2),rS.getString(3),rS.getString(4)); 
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
    public Vector getReporteUsuariosRegistrados() {

        Vector v=new Vector();
        try {
            c = PollDeConexiones.getInstance().getConnection();
            String s = "select u.fecha,u.usuario,u.nombre,u.apellido,ti.nombre,e.detalle from usuarios as u inner join tipoUsuario as ti on u.tipo=ti.codigo inner join estadoEncuesta as e on u.estado=e.codigo ORDER BY u.fecha desc";
            PreparedStatement p = c.prepareStatement(s);

            ResultSet rS = p.executeQuery();

             while (rS.next())
        {   //SE LLAMA A LA CLASE  Y SE LE PASA LOS PARAMETORS OBTENIDOS DELA BASE
           BeanReporteReUsuario rpv=new BeanReporteReUsuario(rS.getDate(1),rS.getString(2),rS.getString(3),rS.getString(4),rS.getString(5),rS.getString(6)); 
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
