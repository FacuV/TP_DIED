package Daos;

import Negocio.Planta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlantaDaoDB implements PlantaDao{
    @Override
    public void createPlanta(Planta planta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        stmt.execute("INSERT INTO planta VALUES ("+String.valueOf(planta.getId())+",'"+planta.getNombre()+"');");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deletePlanta(Planta planta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        stmt.execute("DELETE FROM planta WHERE id_planta = "+String.valueOf(planta.getId())+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updatePlanta(Planta planta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        stmt.execute("UPDATE planta SET nombre_planta = '"+planta.getNombre()+"' WHERE id_planta = "+String.valueOf(planta.getId())+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public Planta getPlanta(int id_planta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        Planta planta = null;
        ResultSet res = stmt.executeQuery("SELECT * FROM planta WHERE id_planta = "+String.valueOf(id_planta)+";");
        if(res.getString("id_planta") != null){
            planta = new Planta(res.getString("nombre_planta"),id_planta,(new StockDaoDB()).getStock(id_planta));
        }
        stmt.close();
        conexion.close();
        return planta;
    }
}
