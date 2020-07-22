package Negocio;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Planta {
    private String nombre;
    private int id;
    private ArrayList<Stock> insumos;
    private PriorityQueue camiones;

    public Planta(String nombre,int id){
        this.nombre = nombre;
        this.id = id;
        insumos = new ArrayList<>();
        camiones = new PriorityQueue();
    }
    public Planta(String nombre,int id,ArrayList insumos,PriorityQueue camiones){
        this.nombre = nombre;
        this.id = id;
        this.insumos = insumos;
        this.camiones = camiones;
    }

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
}
