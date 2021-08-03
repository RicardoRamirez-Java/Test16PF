
package ConexionesBD;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class PollDeConexiones {
    private final String DB="TestDePersonalidad";
    private final String URL="jdbc:postgresql://localhost:5432/"+DB;
    private final String USER="postgres";
    private final String PASS="admin";
    
    private static PollDeConexiones dataSource;
    private BasicDataSource basicDataSource=null;
    
    
    private PollDeConexiones(){
     
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);// minimo de conexiones inactivas que puede haber
        basicDataSource.setMaxIdle(20);// maximo de conexiones inactivas que puede haber
        basicDataSource.setMaxTotal(50);// cuantas conexiones activas e incativas se van a permitir en nuestro pull de conexiones
        basicDataSource.setMaxWaitMillis(-1);// el tiempo de espera (el -1 es para que el cliente espera hasta que se libere una conexion)
       
    }
    
    public static PollDeConexiones getInstance() {
        if (dataSource == null) {
            dataSource = new PollDeConexiones();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException{
      return this.basicDataSource.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }  
    
    
}
