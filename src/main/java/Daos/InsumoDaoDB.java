package Daos;

import Negocio.Insumo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsumoDaoDB implements InsumoDao{
    @Override
    public void createInsumo(Insumo insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_insumo = String.valueOf(insumo.getId_insumo());
        String costo = String.valueOf(insumo.getCosto());
        stmt.execute("INSERT INTO insumo VALUES ('"+id_insumo+"','"+insumo.getDescripcion()+"','"+insumo.getUnidad_medida() );
    }

    @Override
    public void deleteInsumo(Insumo insumo) {
        Connection conexion = ConexionLocal.getConexionLocal();
    }

    @Override
    public void updateInsumo(Insumo insumo) {
        Connection conexion = ConexionLocal.getConexionLocal();
    }

    @Override
    public Insumo getInsumo(int id_insumo) {
        Connection conexion = ConexionLocal.getConexionLocal();

        return null;
    }
}
