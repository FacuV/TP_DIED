package Daos;

import Negocio.Insumo;
import Negocio.Insumo_General;
import Negocio.Insumo_Liquido;

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
        stmt.execute("INSERT INTO insumo VALUES ('"+id_insumo+"','"+insumo.getDescripcion()+"','"+insumo.getUnidad_medida()+"','"+costo+"')");
        if(insumo instanceof Insumo_General){
            String peso = String.valueOf(((Insumo_General) insumo).getPeso_kilos());
            stmt.execute("INSERT INTO general VALUES ('"+id_insumo+"','"+peso+"')");
        }else{
            String densidad = String.valueOf(((Insumo_Liquido) insumo).getDensidad());
            stmt.execute("INSERT INTO liquido VALUES ('"+id_insumo+"','"+densidad+"')");
        }
        stmt.close();
        conexion.close();
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
