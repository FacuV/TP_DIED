package Negocio;

public class Insumo_Liquido extends Insumo{
    //Densidad
    private double densidad;
    @Override
    public double pesoPorUnidad() {
        //ver esto luego
        return densidad*1;
    }
}
