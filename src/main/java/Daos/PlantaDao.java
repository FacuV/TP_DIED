package Daos;

import Negocio.Planta;

import java.sql.SQLException;

public interface PlantaDao {

    public void createPlanta(Planta planta) throws SQLException;
    public void deletePlanta(Planta planta) throws SQLException;
    public void updatePlanta(Planta planta) throws SQLException;
    public Planta getPlanta(int id_planta) throws SQLException;
}
