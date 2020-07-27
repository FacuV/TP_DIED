package Servicio;

import Negocio.Insumo;
import Negocio.Insumo_General;
import Negocio.Insumo_Liquido;

import java.util.ArrayList;

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
    //modificacion(int id_insumo, String descripcion, String unidad_medida, double costo, double peso_densidad): void

}
