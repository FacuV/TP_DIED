package Daos;

import Negocio.Detalle_Envio;

import java.sql.SQLException;

public interface Detalle_EnvioDao {
    public void createDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException;
    public void deleteDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException;
    public void updateDetalle_Envio(Detalle_Envio detalle_envio) throws SQLException;
    public Detalle_Envio getDetalle_Envio(int numero_orden) throws SQLException;
}
