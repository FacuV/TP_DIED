package Daos;

import Negocio.Insumo;

import java.sql.SQLException;

public interface InsumoDao {

    public void createInsumo(Insumo insumo) throws SQLException;
    public void deleteInsumo(Insumo insumo) throws SQLException;
    public void updateInsumo(Insumo insumo) throws SQLException;
    public Insumo getInsumo(int id_insumo) throws SQLException;

}
