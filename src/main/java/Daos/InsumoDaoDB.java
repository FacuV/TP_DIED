package Daos;

import Negocio.Insumo;
import Negocio.Insumo_General;
import Negocio.Insumo_Liquido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsumoDaoDB implements InsumoDao{
    @Override
    public void createInsumo(Insumo insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id_insumo = String.valueOf(insumo.getId_insumo());
        String costo = String.valueOf(insumo.getCosto());
        stmt.execute("INSERT INTO insumo VALUES ("+id_insumo+",'"+insumo.getDescripcion()+"','"+insumo.getUnidad_medida()+"',"+costo+");");
        if(insumo instanceof Insumo_General){
            String peso = String.valueOf(((Insumo_General) insumo).getPeso_kilos());
            stmt.execute("INSERT INTO general VALUES ("+id_insumo+","+peso+");");
        }else{
            String densidad = String.valueOf(((Insumo_Liquido) insumo).getDensidad());
            stmt.execute("INSERT INTO liquido VALUES ("+id_insumo+","+densidad+");");
        }
        stmt.close();
        conexion.close();
    }

    @Override
    public void deleteInsumo(Insumo insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id = String.valueOf(insumo.getId_insumo());
        stmt.execute("DELETE FROM insumo WHERE id_insumo = "+id+";");
        if(insumo instanceof Insumo_General){
            stmt.execute("DELETE FROM general WHERE id_insumo = "+id+";");
        }else{
            stmt.execute("DELETE FROM liquido WHERE id_insumo = "+id+";");
        }
        stmt.close();
        conexion.close();
    }

    @Override
    public void updateInsumo(Insumo insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        String id = String.valueOf(insumo.getId_insumo());
        String costo = String.valueOf(insumo.getCosto());
        stmt.execute("UPDATE insumo SET descripcion = '"+insumo.getDescripcion()+"',unidad_medida = '"+insumo.getUnidad_medida()+"',costo="+costo+" WHERE id_insumo = "+id+";");
        if(insumo instanceof Insumo_General){
            stmt.execute("UPDATE general SET peso = "+String.valueOf(((Insumo_General) insumo).getPeso_kilos())+" WHERE id_insumo = "+id+";");
        }else{
            stmt.execute("UPDATE liquido SET densidad = "+String.valueOf(((Insumo_Liquido) insumo).getDensidad())+" WHERE id_insumo = "+id+";");
        }
        stmt.close();
        conexion.close();
    }

    @Override
    public Insumo getInsumo(int id_insumo) throws SQLException {
        Connection conexion = ConexionLocal.getConexionLocal();
        Statement stmt = conexion.createStatement();
        Insumo insumo = null;
        ResultSet res = stmt.executeQuery("SELECT * FROM insumo " +
                                          "LEFT JOIN general ON general.id_insumo = insumo.id_insumo" +
                                          "LEFT JOIN liquido ON liquido.id_insumo = insumo.id_insumo" +
                                          "WHERE insumo.id_insumo = "+git +";");
        if(res.getString("id_insumo") == null){
            stmt.close();
            conexion.close();
            return insumo;
        }
        if(res.getString("peso") != null){
            insumo = new Insumo_General(id_insumo,res.getString("descripcion"),res.getString("unidad_medida"),Double.valueOf(res.getString("costo")),Double.valueOf(res.getString("peso")));
        }else{
            insumo = new Insumo_Liquido(id_insumo,res.getString("descripcion"),res.getString("unidad_medida"),Double.valueOf(res.getString("costo")),Double.valueOf(res.getString("densidad")));
        }
        stmt.close();
        conexion.close();
        return insumo;
    }
}
