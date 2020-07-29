package Negocio;

import java.util.Objects;

public abstract class Insumo {
    protected int id_insumo;
    protected String descripcion;
    protected String unidad_medida;
    protected double costo;

    public Insumo(int id_insumo, String descripcion, String unidad_medida, double costo) {
        this.id_insumo = id_insumo;
        this.descripcion = descripcion;
        this.unidad_medida = unidad_medida;
        this.costo = costo;
    }

    public abstract double pesoPorUnidad();

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return id_insumo == insumo.id_insumo;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "id_insumo=" + id_insumo +
                '}';
    }
}
