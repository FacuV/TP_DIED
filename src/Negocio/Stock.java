package Negocio;

public class Stock {
    private Insumo insumo;
    private Planta planta;
    private double cantidad;
    private double punto_reposicion;

    public Stock(Insumo insumo,Planta planta, double cantidad, double punto_reposicion) {
        this.insumo = insumo;
        this.planta = planta;
        this.cantidad = cantidad;
        this.punto_reposicion = punto_reposicion;
    }

    public Insumo getInsumo() {return insumo;}

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPunto_reposicion() {
        return punto_reposicion;
    }

    public void setPunto_reposicion(double punto_reposicion) {
        this.punto_reposicion = punto_reposicion;
    }
}
