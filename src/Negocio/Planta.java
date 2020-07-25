package Negocio;

import java.util.*;

public class Planta{
    private String nombre;
    private int id;
    private ArrayList<Lista_insumos> insumos;
    private PriorityQueue<Camion> camiones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Lista_insumos> getInsumos() {
        return insumos;
    }

    public void setInsumos(ArrayList<Lista_insumos> insumos) {
        this.insumos = insumos;
    }

    public PriorityQueue<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(PriorityQueue<Camion> camiones) {
        this.camiones = camiones;
    }

    public Planta(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
        insumos = new ArrayList<>();
        camiones = new PriorityQueue<Camion>(50, Camion::compareTo);
    }
    public Planta(String nombre,int id,ArrayList insumos,PriorityQueue camiones){
        this.nombre = nombre;
        this.id = id;
        this.insumos = insumos;
        this.camiones = camiones;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
