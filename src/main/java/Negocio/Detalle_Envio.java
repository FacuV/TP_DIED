package Negocio;

import java.util.ArrayList;

public class Detalle_Envio {
    private Camion camion_asignado;
    private ArrayList<Ruta> rutas_asignadas;
    private double costo_envio;

    public Detalle_Envio(Camion camion_asignado, ArrayList<Ruta> rutas_asignadas, double costo_envio) {
        this.camion_asignado = camion_asignado;
        this.rutas_asignadas = rutas_asignadas;
        this.costo_envio = costo_envio;
    }

    public Camion getCamion_asignado() {
        return camion_asignado;
    }

    public void setCamion_asignado(Camion camion_asignado) {
        this.camion_asignado = camion_asignado;
    }

    public ArrayList<Ruta> getRutas_asignadas() {
        return rutas_asignadas;
    }

    public void setRutas_asignadas(ArrayList<Ruta> rutas_asignadas) {
        this.rutas_asignadas = rutas_asignadas;
    }

    public double getCosto_envio() {
        return costo_envio;
    }

    public void setCosto_envio(double costo_envio) {
        this.costo_envio = costo_envio;
    }
}
