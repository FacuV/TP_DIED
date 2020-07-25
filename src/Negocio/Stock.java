package Negocio;

public class Stock extends Lista_insumos{
    private Planta planta;
    private double punto_reposicion;

    public Stock(Insumo insumo,Planta planta, double cantidad, double punto_reposicion) {
        super(insumo,cantidad);
        this.planta = planta;
        this.punto_reposicion = punto_reposicion;
    }
    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
    public double getPunto_reposicion() {
        return punto_reposicion;
    }

    public void setPunto_reposicion(double punto_reposicion) {
        this.punto_reposicion = punto_reposicion;
    }
}
