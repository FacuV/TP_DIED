package Negocio;

public class Insumo_Liquido extends Insumo{
    //Densidad
    private double densidad;

    public Insumo_Liquido(int id_insumo, String descripcion, String unidad_medida, double costo, double densidad) {
        super(id_insumo, descripcion, unidad_medida, costo);
        this.densidad = densidad;
    }

    @Override
    public double pesoPorUnidad() {
        //ver esto luego
        return densidad*1;
    }
}
