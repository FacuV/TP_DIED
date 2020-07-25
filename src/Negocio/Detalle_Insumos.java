package Negocio;

public class Detalle_Insumos extends Lista_insumos{
    private Orden_Pedido orden;

    public Detalle_Insumos(Orden_Pedido orden, Insumo insumo, double cantidad) {
        super(insumo,cantidad);
        this.orden = orden;
    }
    public Orden_Pedido getOrden() {
        return orden;
    }

    public void setOrden(Orden_Pedido orden) {
        this.orden = orden;
    }
}
