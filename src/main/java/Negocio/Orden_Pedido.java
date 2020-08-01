package Negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orden_Pedido {
    private int numero;
    private LocalDate fecha_solicitud;
    private LocalDate fecha_maxima_entrega;
    private LocalDate fecha_entrega;
    private Estado estado;
    private Planta planta_destino;
    private ArrayList<Lista_insumos> insumos_pedidos;
    private Detalle_Envio detalle_envio;

    public Orden_Pedido(int numero, LocalDate fecha_solicitud,LocalDate fecha_maxima_entrega, Planta planta_destino,ArrayList<Lista_insumos> insumos_pedidos) {
        this.numero = numero;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_maxima_entrega = fecha_maxima_entrega;
        this.planta_destino = planta_destino;
        this.insumos_pedidos = insumos_pedidos;
        this.estado = Estado.CREADA;
    }

    public Orden_Pedido(int numero, LocalDate fecha_solicitud, LocalDate fecha_maxima_entrega, LocalDate fecha_entrega, Estado estado, Planta planta_destino, ArrayList<Lista_insumos> insumos_pedidos, Detalle_Envio detalle_envio) {
        this.numero = numero;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_maxima_entrega = fecha_maxima_entrega;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.planta_destino = planta_destino;
        this.insumos_pedidos = insumos_pedidos;
        this.detalle_envio = detalle_envio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(LocalDate fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Planta getPlanta_destino() {
        return planta_destino;
    }

    public void setPlanta_destino(Planta planta_destino) {
        this.planta_destino = planta_destino;
    }

    public ArrayList<Lista_insumos> getInsumos_pedidos() {
        return insumos_pedidos;
    }

    public void setInsumos_pedidos(ArrayList insumos_pedidos) {
        this.insumos_pedidos = insumos_pedidos;
    }

    public Detalle_Envio getDetalle_envio() {
        return detalle_envio;
    }

    public void setDetalle_envio(Detalle_Envio detalle_envio) {
        this.detalle_envio = detalle_envio;
    }

    public LocalDate getFecha_maxima_entrega() {
        return fecha_maxima_entrega;
    }

    public void setFecha_maxima_entrega(LocalDate fecha_maxima_entrega) {
        this.fecha_maxima_entrega = fecha_maxima_entrega;
    }
}