package Daos;

import org.postgresql.core.SetupQueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionLocal {
    public static Connection getConexionLocal(){

        String url = "jdbc:postgresql://localhost:5432/tp-died";
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,"postgres","abrosio123");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    };
}
