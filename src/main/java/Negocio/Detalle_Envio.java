package Negocio;

import java.util.ArrayList;

public class Detalle_Envio {
    private Camion camion_asignado;
    private ArrayList<Ruta> rutas_asignadas;
    private double costo_envio;
    private Orden_Pedido orden;

    public Detalle_Envio(Camion camion_asignado, ArrayList<Ruta> rutas_asignadas) {
        this.camion_asignado = camion_asignado;
        this.rutas_asignadas = rutas_asignadas;
        this.costo_envio = this.calcularCosto(camion_asignado,rutas_asignadas);
    }

    public Detalle_Envio(Camion camion_asignado, ArrayList<Ruta> rutas_asignadas, Double costo_envio) {
        this.camion_asignado = camion_asignado;
        this.rutas_asignadas = rutas_asignadas;
        this.costo_envio = costo_envio;
    }

    private double calcularCosto(Camion camion_asignado, ArrayList<Ruta> rutas_asignadas) {
        double cantidad_horas=0.0;
        double cantidad_km=0.0;
        for(Ruta ruta:rutas_asignadas) {
            cantidad_horas += ruta.getDuracion_viaje();
            cantidad_km += ruta.getDistancia();
        }
        double rta = (cantidad_horas * camion_asignado.getCosto_hora()) + (cantidad_km * camion_asignado.getCosto_km());
        return rta;
    }

    public void setOrden(Orden_Pedido o){orden=o;}

    public Orden_Pedido getOrden(){return orden;}

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
