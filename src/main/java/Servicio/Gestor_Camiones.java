package Servicio;

import Negocio.Camion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Gestor_Camiones {
    private static PriorityQueue<Camion> camiones = new PriorityQueue<>();

    public static void registrarCamion(String patente, String marca,String modelo,double Km_recorridos,double costo_km,double costo_hora,LocalDate fecha_compra){
        camiones.add(new Camion(patente,marca,modelo,Km_recorridos,costo_km,costo_hora,fecha_compra));
    }
    public static void baja(String patente){
        for (Camion camion: camiones){
            if(camion.getPatente().equals(patente)){camiones.remove(camion);}
        }
    }
    public static Camion getCamion(String patente){
        for(Camion camion: camiones){
            if(camion.getPatente().equals(patente)){
                return camion;
            }
        }
        return null;
    }
    //Pasar null a los parametros string que no se quieran modificar y -1 a los tipo numericos
    public static void modificacion(String patente, String marca, String modelo, double Km_recorridos, double costo_km, double costo_hora, LocalDate fecha_compra){
        Camion cam = null;
        for (Camion camion: camiones){
            if(camion.getPatente().equals(patente)){cam = camion;}
        }
        if(marca != null){cam.setMarca(marca);}
        if(modelo != null){cam.setModelo(modelo);}
        if(Km_recorridos >= 0){cam.setKm_recorridos(Km_recorridos);}
        if(costo_km >= 0){cam.setCosto_km(costo_km);}
        if(costo_hora >= 0){cam.setCosto_hora(costo_hora);}
        if(fecha_compra != null){cam.setFecha_compra(fecha_compra);}
    }
    public static PriorityQueue<Camion> getCamiones(){
        return camiones;
    }
}

