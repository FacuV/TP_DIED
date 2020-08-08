package Daos;

import Negocio.Planta;
import Negocio.Ruta;
import Servicio.Gestor_Plantas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RutaDaoDB implements RutaDao{
    @Override
    public void createRuta(Ruta ruta) throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        String id_planta_origen = String.valueOf(ruta.getPlanta_origen().getId());
        String id_planta_destino = String.valueOf(ruta.getPlanta_destino().getId());
        String distancia = String.valueOf(ruta.getDistancia());
        String duracion_viaje = String.valueOf(ruta.getDuracion_viaje());
        String cant_max_material = String.valueOf(ruta.getCant_max_material());
        stmt.execute("INSERT INTO ruta VALUES ("+id_planta_origen+","+id_planta_destino+","+distancia+","+duracion_viaje+","+cant_max_material+");");
        stmt.close();
        conexion.close();
    }
    public ArrayList<Ruta> getRuta() throws SQLException {
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();
        ArrayList<Ruta> rtn = new ArrayList<>();
        Ruta ruta;
        ResultSet res = stmt.executeQuery("SELECT * FROM ruta;");
        while (res.next()){
            ruta = new Ruta(Gestor_Plantas.getPlanta(res.getInt("id_planta_origen")),Gestor_Plantas.getPlanta(res.getInt("id_planta_destino")),res.getDouble("distancia"),(int) res.getDouble("duracion_viaje"),res.getDouble("cant_max_material"));
            rtn.add(ruta);
        }
        stmt.close();
        conexion.close();
        return rtn;
    }
}
