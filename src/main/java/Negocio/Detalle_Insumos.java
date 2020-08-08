package Negocio;

public class Detalle_Insumos extends Lista_insumos{

    public Detalle_Insumos(Insumo insumo, double cantidad) {
        super(insumo,cantidad);

    }

    @Override
    public double getPunto_reposicion() {
        return 0;
    }

    @Override
    public void setPunto_reposicion(double punto_reposicion) {}
}
