package Daos;

import Negocio.Planta;

public interface PlantaDao {

    public void createPlanta(Planta planta);
    public void deletePlanta(Planta planta);
    public void updatePlanta(Planta planta);
    public Planta getPlanta(int id_planta);
}
