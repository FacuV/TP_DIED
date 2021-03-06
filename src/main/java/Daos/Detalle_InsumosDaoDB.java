package Daos;

import Negocio.Detalle_Insumos;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Plantas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Detalle_InsumosDaoDB implements Detalle_InsumosDao{
    @Override
    public void createDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        String cantidad = String.valueOf(detalle_insumos.getCantidad());
        stmt.execute("INSERT INTO detalle_insumo VALUES ("+numero_orden+","+id_insumo+","+cantidad+");");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        stmt.execute("DELETE FROM detalle_insumo WHERE numero_orden = "+numero_orden+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_insumos.getOrden().getNumero());
        String id_insumo = String.valueOf(detalle_insumos.getInsumo().getId_insumo());
        String cantidad = String.valueOf(detalle_insumos.getCantidad());
        stmt.execute("UPDATE detalle_insumo SET id_insumo = cantidad = "+cantidad+" WHERE numero_orden = "+numero_orden+" AND id_insumo = "+id_insumo+";");
        stmt.close();
        conexion.close();
    }


}
