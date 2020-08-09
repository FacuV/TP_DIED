package Negocio;

import java.util.*;

public class Planta{
    private String nombre;
    private int id;
    private ArrayList<Lista_insumos> insumos;

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

    public Planta(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
        insumos = new ArrayList<>();
    }

    public Planta(String nombre,int id,ArrayList insumos){
        this.nombre = nombre;
        this.id = id;
        this.insumos = insumos;
    }

    public void agregarInsumo(Insumo insumo, double cantidad, double punto_reposicion){
        insumos.add(new Stock(insumo, this,cantidad,punto_reposicion));
    }
    @Override
    public String toString() {
        return "Planta{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
