package Negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Camion implements Comparable{
    private String patente;
    private String marca;
    private String modelo;
    private double km_recorridos;
    private double costo_km;
    private double costo_hora;
    private LocalDate fecha_compra;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKm_recorridos() {
        return km_recorridos;
    }

    public void setKm_recorridos(double km_recorridos) {
        this.km_recorridos = km_recorridos;
    }

    public double getCosto_km() {
        return costo_km;
    }

    public void setCosto_km(double costo_km) {
        this.costo_km = costo_km;
    }

    public double getCosto_hora() {
        return costo_hora;
    }

    public void setCosto_hora(double costo_hora) {
        this.costo_hora = costo_hora;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Camion(String patente, String marca, String modelo, double km_recorridos, double costo_km, double costo_hora, LocalDate fecha_compra) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km_recorridos = km_recorridos;
        this.costo_km = costo_km;
        this.costo_hora = costo_hora;
        this.fecha_compra = fecha_compra;
    }

    @Override
    public int compareTo(Object o) {
        Double a = this.km_recorridos;
        Camion aux = (Camion) o;
        return a.compareTo(aux.getKm_recorridos());
    }

    public void actualizarKm(ArrayList<Ruta> rutas_asignadas) {
        for(Ruta ruta:rutas_asignadas){
            this.km_recorridos+=ruta.getDistancia();
        }
    }
}
