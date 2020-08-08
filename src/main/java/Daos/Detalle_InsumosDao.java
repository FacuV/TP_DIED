package Daos;

import Negocio.Detalle_Insumos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Detalle_InsumosDao {
    public void createDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException;
    public void deleteDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException;
    public void updateDetalle_Insumos(Detalle_Insumos detalle_insumos) throws SQLException;
}
