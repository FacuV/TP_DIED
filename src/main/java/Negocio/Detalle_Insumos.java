package Negocio;

public class Detalle_Insumos extends Lista_insumos{
    private Orden_Pedido orden;

    public Detalle_Insumos(Insumo insumo, double cantidad) {
        super(insumo,cantidad);
    }

    public void setOrden(Orden_Pedido o){orden=o;}


    public Orden_Pedido getOrden(){return orden;}

    @Override
    public double getPunto_reposicion() {
        return 0;
    }

    @Override
    public void setPunto_reposicion(double punto_reposicion) {}

    public Double getPrecio(){
        return insumo.getCosto()*cantidad;
    }
}
