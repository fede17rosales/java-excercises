package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    public static Connection getConexion(){
        Connection connection = null;
        String dataBase = "bands";
        String url = "jdbc:mysql://localhost:3306/" + dataBase;
        String user = "fede";
        String password = "1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("Error when try connect whith the database: " + e);
        }
        return connection;
    }

}
