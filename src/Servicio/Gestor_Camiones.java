package Servicio;

import Negocio.Camion;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Gestor_Camiones {
    private static ArrayList<Camion> camiones = new ArrayList<>();

    public static void registrarCamion(String patente, String marca,String modelo,double Km_recorridos,double costo_km,double costo_hora,LocalDate fecha_compra){
        camiones.add(new Camion(patente,marca,modelo,Km_recorridos,costo_km,costo_hora,fecha_compra));
    }

}

