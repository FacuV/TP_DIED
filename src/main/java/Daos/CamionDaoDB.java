package Daos;

import Negocio.Camion;
import Negocio.Insumo;
import Negocio.Insumo_General;
import Negocio.Insumo_Liquido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class CamionDaoDB implements CamionDao{


    @Override
    public void createCamion(Camion camion) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String patente = camion.getPatente();
        String marca = camion.getMarca();
        String modelo = camion.getModelo();
        String km_recorridos = String.valueOf(camion.getKm_recorridos());
        String costo_km = String.valueOf(camion.getCosto_km());
        String costo_hora = String.valueOf(camion.getCosto_hora());
        String fecha_compra = String.valueOf(camion.getFecha_compra());
        stmt.execute("INSERT INTO camion VALUES ('"+patente+"','"+marca+"','"+modelo+"',"+km_recorridos+","+costo_km+","+costo_hora+",'"+fecha_compra+"');");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteCamion(Camion camion) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String patente = camion.getPatente();
        stmt.execute("DELETE FROM camion WHERE patente = '"+patente+"';");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateCamion(Camion camion) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String patente = camion.getPatente();
        String marca = camion.getMarca();
        String modelo = camion.getModelo();
        String km_recorridos = String.valueOf(camion.getKm_recorridos());
        String costo_km = String.valueOf(camion.getCosto_km());
        String costo_hora = String.valueOf(camion.getCosto_hora());
        String fecha_compra = String.valueOf(camion.getFecha_compra());
        stmt.execute("UPDATE camion SET marca ='"+marca+"', modelo = '"+modelo+"', km_recorridos = "+km_recorridos+", costo_km = "+costo_km+", costo_hora = "+costo_hora+", fecha_compra = '"+fecha_compra+"' WHERE patente = '"+patente+"';");
        stmt.close();
        conexion.close();
    }

    @Override
    public Camion getCamion(String patente) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        Camion camion = null;
        ResultSet res = stmt.executeQuery("SELECT * FROM camion WHERE patente = '"+patente+"';");
        if(res.getString("patente")!=null) {
            camion = new Camion(patente, res.getString("marca"), res.getString("modelo"), Double.valueOf(res.getString("km_recorridos")), Double.valueOf(res.getString("costo_km")), Double.valueOf(res.getString("costo_hora")), LocalDate.parse(res.getString("fecha_compra")));
        }
        stmt.close();
        conexion.close();
        return camion;
    }
}
