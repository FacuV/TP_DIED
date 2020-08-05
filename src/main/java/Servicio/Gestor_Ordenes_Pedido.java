package Servicio;

import Daos.Orden_PedidoDaoDB;
import Negocio.Lista_insumos;
import Negocio.Orden_Pedido;
import Negocio.Planta;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Gestor_Ordenes_Pedido {
    //Esta es una lista con todas las ordenes de pedido que alguna vez realizó la empresa
    private static ArrayList<Orden_Pedido> ordenes = new ArrayList<>();

    //Este método agrega una nueva orden de pedido a la lista de ordenes de la empresa y a la base de datos
    public static void registrarOrden(Planta planta_destino, LocalDate fecha_maxima_entrega, ArrayList<Lista_insumos> insumos_pedidos) throws SQLException {
        int numero;
        if(ordenes.isEmpty()){
            numero = 1;
        }else{
            numero = ordenes.get(ordenes.size()-1).getNumero()+1;
        }
        Orden_Pedido orden_pedido = new Orden_Pedido(numero,LocalDate.now(),fecha_maxima_entrega,planta_destino,insumos_pedidos);
        ordenes.add(orden_pedido);
        Orden_PedidoDaoDB orden_pedidoDaoDB = new Orden_PedidoDaoDB();
        orden_pedidoDaoDB.createOrden_Pedido(orden_pedido);
    }

    //Este método devuelve una orden de pedido con el número de orden que le pasen como id
    public static Orden_Pedido getOrden(int numero){
        return ordenes.get(numero-1);
    }
}
