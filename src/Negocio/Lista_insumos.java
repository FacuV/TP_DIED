package Negocio;

public abstract class Lista_insumos {
    protected Insumo insumo;
    protected double cantidad;

    public Lista_insumos(Insumo insumo, double cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }
    public abstract double getPunto_reposicion();
    public abstract void setPunto_reposicion(double punto_reposicion);

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

        if (o == null || (getClass() != o.getClass() && (o.getClass() != Stock.class && o.getClass() != Detalle_Envio.class))) return false;
        Lista_insumos that = (Lista_insumos) o;
        return insumo.equals(that.insumo);
    }

    @Override
    public String toString() {
        return "Lista_insumos{" +
                "insumo=" + insumo +
                ", cantidad=" + cantidad +
                '}';
    }
}
