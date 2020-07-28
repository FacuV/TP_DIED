package Negocio;

public class Insumo_General extends Insumo{
    //Peso en kilos por unidad de medida
    private double peso_kilos;

    public Insumo_General(int id_insumo, String descripcion, String unidad_medida, double costo,double peso_kilos) {
        super(id_insumo, descripcion, unidad_medida, costo);
        this.peso_kilos = peso_kilos;
    }

    @Override
    public double pesoPorUnidad() {
        return peso_kilos;
    }

    public double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }
}
