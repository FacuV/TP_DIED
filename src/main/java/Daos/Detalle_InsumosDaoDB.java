package Daos;

import Negocio.Detalle_Insumos;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Ordenes_Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_InsumosDaoDB implements Detalle_InsumosDao{
    @Override
    public void createDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        String cantidad = String.valueOf(detalle_insumos.getCantidad());
        stmt.execute("INSERT INTO detalle_insumos VALUES ("+numero_orden+","+id_insumo+","+cantidad+");");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        stmt.execute("DELETE FROM detalle_insumos WHERE numero_orden = "+numero_orden+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        String cantidad = String.valueOf(detalle_insumos.getCantidad());
        stmt.execute("UPDATE detalle_insumos SET id_insumo = cantidad = "+cantidad+" WHERE numero_orden = "+numero_orden+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public Detalle_Insumos getDetalle_Insumos(int numero_orden, int id_insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM detalle_insumos WHERE numero_orden = "+numero_orden+" AND id_insumo = "+id_insumo+";");
        Detalle_Insumos detalle_insumos = new Detalle_Insumos(Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))), Gestor_Insumos.getInsumo(Integer.valueOf(res.getString("id_insumo"))),Double.valueOf(res.getString("cantidad")));
        stmt.close();
        conexion.close();
        return detalle_insumos;
    }
}
