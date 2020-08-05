package Daos;

import Negocio.*;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Plantas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Orden_PedidoDaoDB implements Orden_PedidoDao {
    @Override
    public void createOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(orden_pedido.getNumero());
        String id_planta = String.valueOf(orden_pedido.getPlanta_destino().getId());
        String fecha_solicitud = String.valueOf(orden_pedido.getFecha_solicitud());
        String fecha_maxima_entrega = String.valueOf(orden_pedido.getFecha_maxima_entrega());
        String fecha_entrega = String.valueOf(orden_pedido.getFecha_entrega());
        String estado = String.valueOf(orden_pedido.getEstado());
        stmt.execute("INSERT INTO orden_pedido VALUES ("+numero_orden+","+id_planta+",'"+fecha_solicitud+"','"+fecha_maxima_entrega+"','"+fecha_entrega+"','"+estado+"');");
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(orden_pedido.getNumero());
        stmt.execute("DELETE FROM orden_pedido WHERE numero_orden = "+numero_orden+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(orden_pedido.getNumero());
        String id_planta = String.valueOf(orden_pedido.getPlanta_destino().getId());
        String fecha_solicitud = String.valueOf(orden_pedido.getFecha_solicitud());
        String fecha_maxima_entrega = String.valueOf(orden_pedido.getFecha_maxima_entrega());
        String fecha_entrega = String.valueOf(orden_pedido.getFecha_entrega());
        String estado = String.valueOf(orden_pedido.getEstado());
        stmt.execute("UPDATE orden_pedido SET id_planta = "+id_planta+", fecha_solicitud = '"+fecha_solicitud+"', fecha_maxima_entrega = '"+fecha_maxima_entrega+"', fecha_entrega = '"+fecha_entrega+"', estado = '"+estado+"' WHERE numero_orden = "+numero_orden+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public Orden_Pedido getOrden_Pedido(int numero_orden) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM orden_pedido WHERE numero_orden = "+numero_orden+";");
        Orden_Pedido orden_pedido = new Orden_Pedido(numero_orden, LocalDate.parse(res.getString("fecha_solicitud")),LocalDate.parse(res.getString("fecha_maxima_entrega")),LocalDate.parse(res.getString("fecha_entrega")), Estado.valueOf(res.getString("estado")),Gestor_Plantas.getPlanta(Integer.valueOf(res.getString("id_planta"))),(new Detalle_InsumosDaoDB()).getDetalle_Insumos(numero_orden),(new Detalle_EnvioDaoDB()).getDetalle_Envio(numero_orden));
        stmt.close();
        conexion.close();
        return orden_pedido;
    }
}
