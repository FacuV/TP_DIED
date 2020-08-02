package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionRemota {
    public static Connection getConexionRemota(){
        Connection conexion;
        String url = "jdbc:postgresql://tp-died.cek12yqxgquj.sa-east-1.rds.amazonaws.com:5432/tpdied";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,"postgres","emadb123");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
