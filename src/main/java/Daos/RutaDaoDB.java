package Daos;

import Negocio.Ruta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RutaDaoDB implements RutaDao{
    @Override
    public void createRuta(Ruta ruta) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_planta_origen = String.valueOf(ruta.getPlanta_origen().getId());
        String id_planta_destino = String.valueOf(ruta.getPlanta_destino().getId());
        String distancia = String.valueOf(ruta.getDistancia());
        String duracion_viaje = String.valueOf(ruta.getDuracion_viaje());
        String cant_max_material = String.valueOf(ruta.getCant_max_material());
        stmt.execute("INSERT INTO camion VALUES ("+id_planta_origen+","+id_planta_destino+","+distancia+","+duracion_viaje+","+cant_max_material+");");
        stmt.close();
        conexion.close();
    }
}
