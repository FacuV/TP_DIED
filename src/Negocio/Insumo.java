package Negocio;

public abstract class Insumo {
    private int id_insumo;
    private String descripcion;
    private String unidad_medida;
    private double costo;



    public abstract double pesoPorUnidad();
}
