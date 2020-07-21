package Negocio;

public class Ruta {
    private Planta planta_origen;
    private Planta planta_destino;
    private double distancia;
    private int duracion_viaje;
    private double cant_max_material;

    public Ruta(Planta planta_origen, Planta planta_destino, double distancia, int duracion_viaje, double cant_max_material) {
        this.planta_origen = planta_origen;
        this.planta_destino = planta_destino;
        this.distancia = distancia;
        this.duracion_viaje = duracion_viaje;
        this.cant_max_material = cant_max_material;
    }

    public Planta getPlanta_origen() {
        return planta_origen;
    }

    public void setPlanta_origen(Planta planta_origen) {
        this.planta_origen = planta_origen;
    }

    public Planta getPlanta_destino() {
        return planta_destino;
    }

    public void setPlanta_destino(Planta planta_destino) {
        this.planta_destino = planta_destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getDuracion_viaje() {
        return duracion_viaje;
    }

    public void setDuracion_viaje(int duracion_viaje) {
        this.duracion_viaje = duracion_viaje;
    }

    public double getCant_max_material() {
        return cant_max_material;
    }

    public void setCant_max_material(double cant_max_material) {
        this.cant_max_material = cant_max_material;
    }
}
