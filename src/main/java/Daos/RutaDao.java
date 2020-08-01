package Daos;

import Negocio.Ruta;

import java.sql.SQLException;

public interface RutaDao {
    public void createRuta(Ruta ruta) throws SQLException;
}
