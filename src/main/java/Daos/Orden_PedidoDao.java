package Daos;

import Negocio.Orden_Pedido;

import java.sql.SQLException;

public interface Orden_PedidoDao {
    public void createOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException;
    public void deleteOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException;
    public void updateOrden_Pedido(Orden_Pedido orden_pedido) throws SQLException;
}
