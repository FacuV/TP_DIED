package Daos;

import Negocio.Camion;
import Negocio.Stock;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Plantas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class StockDaoDB implements StockDao{
    @Override
    public void createStock(Stock stock) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_planta = String.valueOf(stock.getPlanta().getId());
        String id_insumo = String.valueOf(stock.getInsumo().getId_insumo());
        String cantidad = String.valueOf(stock.getCantidad());
        String punto_reposicion = String.valueOf(stock.getPunto_reposicion());
        stmt.execute("INSERT INTO stock VALUES ("+id_planta+","+id_insumo+","+cantidad+","+punto_reposicion+");");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteStock(Stock stock) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_planta = String.valueOf(stock.getPlanta().getId());
        String id_insumo = String.valueOf(stock.getInsumo().getId_insumo());
        stmt.execute("DELETE FROM stock WHERE id_planta = "+id_planta+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateStock(Stock stock) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_planta = String.valueOf(stock.getPlanta().getId());
        String id_insumo = String.valueOf(stock.getInsumo().getId_insumo());
        String cantidad = String.valueOf(stock.getCantidad());
        String punto_reposicion = String.valueOf(stock.getPunto_reposicion());
        stmt.execute("UPDATE stock SET cantidad ="+cantidad+", punto_reposicion = "+punto_reposicion+" WHERE id_planta = "+id_planta+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public ArrayList getStock(int id_planta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        ArrayList listaStock = new ArrayList();
        ResultSet res = stmt.executeQuery("SELECT * FROM stock WHERE id_planta = "+id_planta+";");
        while (res.next()){
            Stock stock = new Stock(Gestor_Insumos.getInsumo(Integer.valueOf(res.getString("id_insumo"))),Gestor_Plantas.getPlanta(id_planta),Double.valueOf(res.getString("cantidad")),Double.valueOf(res.getString("punto_reposicion")));
            listaStock.add(stock);
        }
        stmt.close();
        conexion.close();
        return listaStock;
    }
}
