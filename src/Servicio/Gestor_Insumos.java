package Servicio;

import Negocio.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Gestor_Insumos{
    private static ArrayList<Insumo> insumos = new ArrayList<>();

    public static void registrarInsumoG(String descripcion, String unidad_medida, double costo, double peso){
        int id;
        if(insumos.isEmpty()){
            id = 1;
        }else{
            id = insumos.get(insumos.size()-1).getId_insumo()+1;
        }
        insumos.add(new Insumo_General(id,descripcion,unidad_medida,costo,peso));
    }
    public static void registrarInsumoI(String descripcion, String unidad_medida, double costo, double densidad){
        int id;
        if(insumos.isEmpty()){
            id = 1;
        }else{
            id = insumos.get(insumos.size()-1).getId_insumo()+1;
        }
        insumos.add(new Insumo_Liquido(id,descripcion,unidad_medida,costo,densidad));
    }
    public static void baja(int id_insumo){
        insumos.remove(insumos.get(id_insumo-1));
    }
    //Pasar null en los dos primeros si no se los quiere modificar y 0 en los demas que no se quieran modficar
    public static void modificacion(int id_insumo, String descripcion, String unidad_medida, double costo, double peso_densidad){
        Insumo insumo = insumos.get(id_insumo-1);
        if(descripcion != null){insumo.setDescripcion(descripcion);}
        if(unidad_medida != null){insumo.setUnidad_medida(unidad_medida);}
        if(costo > 0){insumo.setCosto(costo);}
        if(peso_densidad > 0){
            if(insumo instanceof Insumo_General){
                ((Insumo_General) insumos.get(id_insumo-1)).setPeso_kilos(peso_densidad);
            }else{
                ((Insumo_Liquido) insumos.get(id_insumo-1)).setDensidad(peso_densidad);
            }
        }
    }
    public static List<Insumo> getInsumos(){return insumos;}
    public static Insumo getInsumo(int id_insumo){return insumos.get(id_insumo-1);}
    public static int cantidadTotal(Insumo insumo){
        int rtn = 0;
        for(Planta planta:Gestor_Plantas.getPlantas()){
            for(Lista_insumos stock: planta.getInsumos()){
                if(stock.getInsumo().equals(insumo)){rtn+= stock.getCantidad();}
            }
        }
        return  rtn;
    }
}
