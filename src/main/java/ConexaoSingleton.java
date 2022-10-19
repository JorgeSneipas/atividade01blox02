import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {
     private static Connection conn = null;

     ConexaoSingleton() throws SQLException {
         String jdbcURL = "jdbc:h2:mem:test";
         String username = "sa";
         String password = "1234";

         if(conn == null) {
             conn = DriverManager.getConnection(jdbcURL, username, password);
             System.out.println("Connected database.");
         }
     }

     public Connection getConn(){ return conn; }
}
