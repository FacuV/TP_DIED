package Negocio;

public class Detalle_Insumos {
    private Orden_Pedido orden;
    private Insumo insumo;
    private double cantidad;

    public Detalle_Insumos(Orden_Pedido orden, Insumo insumo, double cantidad) {
        this.orden = orden;
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public Orden_Pedido getOrden() {
        return orden;
    }

    public void setOrden(Orden_Pedido orden) {
        this.orden = orden;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
