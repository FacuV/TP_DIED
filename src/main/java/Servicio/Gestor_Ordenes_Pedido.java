package Servicio;

import Negocio.Lista_insumos;
import Negocio.Orden_Pedido;
import Negocio.Planta;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Gestor_Ordenes_Pedido {
    private static ArrayList<Orden_Pedido> ordenes = new ArrayList<>();

    public static void registrarOrden(Planta planta_destino, LocalDate fecha_maxima_entrega, ArrayList<Lista_insumos> insumos_pedidos){
        int numero;
        if(ordenes.isEmpty()){
            numero = 1;
        }else{
            numero = ordenes.get(ordenes.size()-1).getNumero()+1;
        }
        ordenes.add(new Orden_Pedido(numero,LocalDate.now(),fecha_maxima_entrega,planta_destino,insumos_pedidos));
    }
    public static Orden_Pedido getOrden(int numero){
        return ordenes.get(numero-1);
    }
}
