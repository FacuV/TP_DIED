package Daos;

import Negocio.Detalle_Envio;
import Negocio.Ruta;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Plantas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Detalle_EnvioDaoDB implements Detalle_EnvioDao{

    @Override
    public void createDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_envio.getOrden().getNumero());
        String patente = detalle_envio.getCamion_asignado().getPatente();
        String costo_envio = String.valueOf(detalle_envio.getCosto_envio());
        ArrayList<Ruta> rutas = detalle_envio.getRutas_asignadas();
        stmt.execute("INSERT INTO detalle_envio VALUES ("+numero_orden+",'"+patente+"',"+costo_envio+");");
        for(Ruta camino:rutas){
            String id_planta_origen = String.valueOf(camino.getPlanta_origen().getId());
            String id_planta_destino = String.valueOf(camino.getPlanta_destino().getId());
            stmt.execute("INSERT INTO camino VALUES ("+id_planta_origen+","+id_planta_destino+","+numero_orden+");");
        }
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_envio.getOrden().getNumero());
        stmt.execute("DELETE FROM detalle_envio WHERE numero_orden = "+numero_orden+";");
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String numero_orden = String.valueOf(detalle_envio.getOrden().getNumero());
        String patente = detalle_envio.getCamion_asignado().getPatente();
        String costo_envio = String.valueOf(detalle_envio.getCosto_envio());
        ArrayList<Ruta> rutas = detalle_envio.getRutas_asignadas();
        stmt.execute("UPDATE detalle_envio SET patente = '"+patente+"', costo_envio = "+costo_envio+" WHERE numero_orden = "+numero_orden+";");
        stmt.execute("DELETE FROM camino WHERE numero_orden = "+numero_orden+";");
        for(Ruta camino:rutas){
            String id_planta_origen = String.valueOf(camino.getPlanta_origen().getId());
            String id_planta_destino = String.valueOf(camino.getPlanta_destino().getId());
            stmt.execute("INSERT INTO camino VALUES ("+id_planta_origen+","+id_planta_destino+","+numero_orden+");");
        }
        stmt.close();
        conexion.close();
    }


}
