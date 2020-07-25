package Negocio;

import java.util.*;
import java.util.stream.Stream;

public class Planta implements List {
    private String nombre;
    private int id;
    private ArrayList<Stock> insumos;
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

    public ArrayList<Stock> getInsumos() {
        return insumos;
    }

    public void setInsumos(ArrayList<Stock> insumos) {
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
    @Override
    public Stream stream(){
        ArrayList aux = new ArrayList();
        aux.add(this);
        return aux.stream();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

}
