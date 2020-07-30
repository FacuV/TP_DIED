package Daos;

import Negocio.Insumo;

import java.sql.SQLException;

public interface InsumoDao {

    public void createInsumo(Insumo insumo) throws SQLException;
    public void deleteInsumo(Insumo insumo);
    public void updateInsumo(Insumo insumo);
    public Insumo getInsumo(int id_insumo);

}
