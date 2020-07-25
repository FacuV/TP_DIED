package Negocio;

import java.util.Objects;

public abstract class Lista_insumos {
    protected Insumo insumo;
    protected double cantidad;

    public Lista_insumos(Insumo insumo, double cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }
    public abstract double getPunto_reposicion();

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista_insumos that = (Lista_insumos) o;
        return insumo.equals(that.insumo);
    }

}
