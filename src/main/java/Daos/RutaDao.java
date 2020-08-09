package Daos;

import Negocio.Ruta;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RutaDao {
    public void createRuta(Ruta ruta) throws SQLException;
    public ArrayList<Ruta> getRuta() throws SQLException;
}
