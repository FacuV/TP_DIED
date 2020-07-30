package Daos;

import Negocio.Camion;


import java.sql.SQLException;

public interface CamionDao {

    public void createCamion(Camion camion) throws SQLException;
    public void deleteCamion(Camion camion) throws SQLException;
    public void updateCamion(Camion camion) throws SQLException;
    public Camion getCamion(String patente) throws SQLException;
}
