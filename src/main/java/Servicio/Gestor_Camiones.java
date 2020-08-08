package Servicio;

import Daos.CamionDaoDB;
import Negocio.Camion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Gestor_Camiones {
    //Esta es la cola de prioridad de los camiones que posee la empresa
    private static PriorityQueue<Camion> camiones = new PriorityQueue<>();


    //Este método registra un nuevo camión en la cola de prioridad de camiones y en la base de datos
    public static void registrarCamion(String patente, String marca,String modelo,double Km_recorridos,double costo_km,double costo_hora,LocalDate fecha_compra) throws SQLException {
        Camion c = new Camion(patente,marca,modelo,Km_recorridos,costo_km,costo_hora,fecha_compra);
        camiones.add(c);
        CamionDaoDB cdb = new CamionDaoDB();
        cdb.createCamion(c);

    }

    //Este método me permite, después de traer desde la base de datos un camión, almacenarlo en la lista de prioridades
    public static void traerCamionBD(String patente, String marca,String modelo,double Km_recorridos,double costo_km,double costo_hora,LocalDate fecha_compra){
        Camion c = new Camion(patente, marca, modelo, Km_recorridos, costo_km, costo_hora, fecha_compra);
        camiones.add(c);
    }

    //Este método borra un camión de la cola de prioridad de camiones y de la base de datos
    public static void baja(String patente) throws SQLException {
        for (Camion camion: camiones){
            if(camion.getPatente().equals(patente)){
                camiones.remove(camion);
                CamionDaoDB cdb = new CamionDaoDB();
                cdb.deleteCamion(camion);
            }
        }
    }

    //Este método devuelve un camión de la cola de prioridad de camiones según su patente (puede que no lo usemos)
    public static Camion getCamion(String patente){
        for(Camion camion: camiones){
            if(camion.getPatente().equals(patente)){
                return camion;
            }
        }
        return null;
    }

    //Pasar null a los parametros string que no se quieran modificar y -1 a los tipo numericos
    //Este método modifica los parámetros que se le pasen de un camión con la patente que indica, tanto en la cola de prioridad como en la base de datos
    public static void modificacion(String patente, String marca, String modelo, double Km_recorridos, double costo_km, double costo_hora, LocalDate fecha_compra) throws SQLException {
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
        CamionDaoDB cdb = new CamionDaoDB();
        cdb.updateCamion(cam);
    }

    //Este método retorna la cola de prioridad de camiones
    public static PriorityQueue<Camion> getCamiones(){
        return camiones;
    }
}

