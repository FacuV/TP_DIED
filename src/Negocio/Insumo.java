package Negocio;

public abstract class Insumo {
    protected int id_insumo;
    protected String descripcion;
    protected String unidad_medida;
    protected double costo;

    public Insumo(int id_insumo, String descripcion, String unidad_medida, double costo) {
        this.id_insumo = id_insumo;
        this.descripcion = descripcion;
        this.unidad_medida = unidad_medida;
        this.costo = costo;
    }

    public abstract double pesoPorUnidad();
}
