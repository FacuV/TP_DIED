package Negocio;

public class Insumo_General extends Insumo{
    //Peso en kilos por unidad de medida
    private double peso_kilos;

    @Override
    public double pesoPorUnidad() {
        return peso_kilos;
    }
}
