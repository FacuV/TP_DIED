package Servicio;

import Daos.Detalle_EnvioDaoDB;
import Daos.Detalle_InsumosDaoDB;
import Daos.Orden_PedidoDaoDB;
import Negocio.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        for(Lista_insumos insumos:insumos_pedidos){
            insumos.setOrden(orden_pedido);
        }
        Orden_PedidoDaoDB orden_pedidoDaoDB = new Orden_PedidoDaoDB();
        orden_pedidoDaoDB.createOrden_Pedido(orden_pedido);
        Detalle_InsumosDaoDB detalle_insumosDaoDB = new Detalle_InsumosDaoDB();
        for(int i=0; i < insumos_pedidos.size();i++){
            detalle_insumosDaoDB.createDetalle_Insumos((Detalle_Insumos)insumos_pedidos.get(i));
        }

    }

    //Este método te deja registrar una planta después de sacarla de la base de datos
    public static void traerOrdenBD(int numero, LocalDate fecha_solicitud, LocalDate fecha_maxima_entrega, LocalDate fecha_entrega, Estado estado, Planta planta_destino, ArrayList<Lista_insumos> insumos_pedidos, Detalle_Envio detalle_envio){
        Orden_Pedido orden_pedido = new Orden_Pedido(numero,fecha_solicitud, fecha_maxima_entrega,fecha_entrega,estado, planta_destino,insumos_pedidos, detalle_envio);
        ordenes.add(orden_pedido);
    }

    //Este método devuelve una orden de pedido con el número de orden que le pasen como id
    public static Orden_Pedido getOrden(int numero){
        return ordenes.get(numero-1);
    }

    //Este método cambia una orden a PROCESADA
    public static void pasarAProcesada(Orden_Pedido orden, Camion camion, ArrayList<Ruta> rutas_asignadas,double costo_envio) throws SQLException {
        orden.setEstado(Estado.PROCESADA);
        Detalle_Envio detalle_envio = new Detalle_Envio(camion,rutas_asignadas,costo_envio);
        orden.setDetalle_envio(detalle_envio);
        Detalle_EnvioDaoDB detalle_envioDaoDB = new Detalle_EnvioDaoDB();
        detalle_envioDaoDB.createDetalle_Envio(detalle_envio);
        Orden_PedidoDaoDB orden_pedidoDaoDB = new Orden_PedidoDaoDB();
        orden_pedidoDaoDB.updateOrden_Pedido(orden);
    }

    //Este método cambia una orden a CANCELADA
    public static void pasarACancelada(Orden_Pedido orden) throws SQLException {
        orden.setEstado(Estado.CANCELADA);
        Orden_PedidoDaoDB orden_pedidoDaoDB = new Orden_PedidoDaoDB();
        orden_pedidoDaoDB.updateOrden_Pedido(orden);
    }

    //Este método cambia una orden a ENTREGADA
    public static void pasarAEntregada(Orden_Pedido orden) throws SQLException {
        orden.setEstado(Estado.ENTREGADA);
        orden.setFecha_entrega(LocalDate.now());
        Orden_PedidoDaoDB orden_pedidoDaoDB = new Orden_PedidoDaoDB();
        orden_pedidoDaoDB.updateOrden_Pedido(orden);
    }
}
