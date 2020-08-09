package Servicio;

import Interface.camion.Pantalla_Camion;
import Interface.insumo.Pantalla_Insumo;
import Interface.ordenesPedido.Pantalla_Ordenes;
import Interface.planta.Pantalla_Plantas;
import Interface.Pantalla_Principal;
import Interface.ruta.Pantalla_Rutas;
import Negocio.Insumo;
import Negocio.Planta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Gestor_Pantalla {
    //pantalla principal
    private static final JFrame pantalla_principal = new Pantalla_Principal();
    //pantallas secundarias accedidas mediante botones de la pantalla principal
    private static final JFrame pantalla_plantas = new Pantalla_Plantas();
    private static final JFrame pantalla_camiones = new Pantalla_Camion();
    private static final JFrame pantalla_rutas = new Pantalla_Rutas();
    private static final JFrame pantalla_insumos = new Pantalla_Insumo();
    private static final JFrame pantalla_ordenes = new Pantalla_Ordenes();

    public static final int PRINCIPAL = 0;
    public static final int PLANTAS = 1;
    public static final int CAMIONES = 2;
    public static final int RUTAS = 3;
    public static final int INSUMOS = 4;
    public static final int ORDENES = 5;

    private static JFrame[] pantallas_secundarias = {pantalla_principal,pantalla_plantas,pantalla_camiones,pantalla_rutas,pantalla_insumos,pantalla_ordenes};
    private static boolean[] info_pantallas = {false,false,false,false,false,false};
    public static void setOffAll(){
        for(int i=0;i<pantallas_secundarias.length;i++){
            if(info_pantallas[i]){
                info_pantallas[i] = false;
                pantallas_secundarias[i].setVisible(false);
            }
        }
    }
    public static void visualizarPantalla_principal(){
        info_pantallas[PRINCIPAL] = true;
        pantalla_principal.setVisible(true);
    }
    public static void noVisualizarPantalla_principal(){
        info_pantallas[PRINCIPAL] = false;
        pantalla_principal.setVisible(false);
    }

    public static void visualizarPantalla_plantas(){
        info_pantallas[PLANTAS] = true;
        pantalla_plantas.setVisible(true);
    }
    public static void noVisualizarPantalla_plantas(){
        info_pantallas[PLANTAS] = false;
        pantalla_plantas.setVisible(false);
    }

    public static void visualizarPantalla_camiones(){info_pantallas[CAMIONES] = true;pantalla_camiones.setVisible(true);}
    public static void noVisualizarPantalla_camiones(){info_pantallas[CAMIONES] = false;pantalla_camiones.setVisible(false);}

    public static void visualizarPantalla_rutas(){info_pantallas[RUTAS] = true;pantalla_rutas.setVisible(true);}
    public static void noVisualizarPantalla_rutas(){info_pantallas[RUTAS] = false;pantalla_rutas.setVisible(false);}

    public static void visualizarPantalla_insumos(){info_pantallas[INSUMOS] = true;;pantalla_insumos.setVisible(true);}
    public static void noVisualizarPantalla_insumos(){info_pantallas[INSUMOS] = false;pantalla_insumos.setVisible(false);}

    public static void visualizarPantalla_ordenes(){info_pantallas[ORDENES] = true;pantalla_ordenes.setVisible(true);}
    public static void noVisualizarPantalla_ordenes(){info_pantallas[ORDENES] = false;pantalla_ordenes.setVisible(false);}
    /*public static String[][] getMatrizBajoPuntoReposicion(Planta filtroPlanta,Insumo filtroInsumo) {
        String[] titulos = new String[]{"PLANTA", "INSUMO", "STOCK EN PLANTA", "PUNTO DE PEDIDO", "STOCK TOTAL"};
        List<List> todasLasPlantasInsumo = Gestor_Plantas.plantasBajoPuntoReposicion();
            if(filtroPlanta == null){
                for(List l: todasLasPlantasInsumo){
                    if(!l.get(0).equals(filtroPlanta)) {
                        todasLasPlantasInsumo.remove(l);
                    }
                }
            }
            if(filtroInsumo == null){
                for(List l: todasLasPlantasInsumo){
                    if(!l.get(1).equals(filtroInsumo)) {
                        todasLasPlantasInsumo.remove(l);
                    }
                }
            }
        String informacion[][] = new String[todasLasPlantasInsumo.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] =  + "";
            informacion[x][1] = flujos.get(x).toString()+ "";
            informacion[x][2] = todasLasPlantas.get(x).toString() + "";
            informacion[x][3] = todasLasPlantas.get(x).toString() + "";
            informacion[x][4] = todasLasPlantas.get(x).toString() + "";
        }
        return informacion;
    }}

     */


    public static String[][] getMatrizPlantasFlujoMax(Planta inicio,Planta fin){
        String[] titulos = new String[]{"CAMINO","KG"};
        ArrayList todasLasPlantas = Gestor_Plantas.flujoMaxPlantas(inicio,fin);
        ArrayList flujos = Gestor_Plantas.flujoMaxSubPesos(inicio, fin);
        String informacion[][] = new String[todasLasPlantas.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = todasLasPlantas.get(x).toString() + "";
            informacion[x][1] = flujos.get(x).toString()+ "";
        }
        return informacion;
    }
    public static String[][] getMatrizPlantasCaminosMinimo(){
        String[] titulos = new String[]{"PLANTA ORIGEN","PLANTA DESTINO","CAMINO MAS CORTO","CAMINO MAS RAPIDO"};
        List[][] porTiempo = Gestor_Plantas.matrizCaminoMinimo(true);
                ArrayList<List> porTiempoPlano = new ArrayList();
                for (int x = 0; x < porTiempo.length; x++) {
                    for(int i = 0; i < porTiempo.length; i++){
                        if(!porTiempo[x][i].isEmpty()){
                            porTiempoPlano.add(porTiempo[x][i]);
                        }
                    }
                }
        List[][] porDistancia = Gestor_Plantas.matrizCaminoMinimo(false);
            ArrayList<List> porDistanciaPlano = new ArrayList();
        for (int x = 0; x < porDistancia.length; x++) {
            for(int i = 0; i < porDistancia.length; i++){
                if(!porDistancia[x][i].isEmpty()){
                    porDistanciaPlano.add(porDistancia[x][i]);
                }
            }
        }
        String informacion[][] = new String[porTiempoPlano.size()][titulos.length];
        for (int x = 0; x < porTiempoPlano.size(); x++) {
            informacion[x][0] = porTiempoPlano.get(x).get(0)+"";
            informacion[x][1] = porTiempoPlano.get(x).get(porTiempoPlano.get(x).size()-1)+"";
            informacion[x][2] = porTiempoPlano.get(x)+"";
            informacion[x][3] = porDistanciaPlano.get(x)+"";

        }
        return informacion;
    }
    public static String[][] getMatrizPlantas(String nombre){
        String[] titulos = new String[]{"ID Planta","Nombre"};
        ArrayList<Planta> todasLasPlantas = Gestor_Plantas.getPlantas();
        ArrayList<Planta> plantasSeleccionadas = new ArrayList<>();
        if(nombre == null || nombre.isBlank()){
            plantasSeleccionadas = todasLasPlantas;
        }else{
            for (Planta planta: todasLasPlantas){
                if(planta.getNombre().contains(nombre)) plantasSeleccionadas.add(planta);
            }
        }
        return obtenerMatrizDatos(plantasSeleccionadas,titulos);
    }
    private static String[][] obtenerMatrizDatos(ArrayList<Planta> plantas,String[] titulos) {

        String informacion[][] = new String[plantas.size()][titulos.length];

        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = plantas.get(x).getId() + "";
            informacion[x][1] = plantas.get(x).getNombre()+ "";
        }
        return informacion;
    }


}

