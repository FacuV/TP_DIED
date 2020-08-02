package Servicio;

import Interface.analisisPlantas.Pantalla_AnalisisPlantas;
import Interface.camion.Pantalla_Camion;
import Interface.insumo.Pantalla_Insumo;
import Interface.ordenesPedido.Pantalla_Ordenes;
import Interface.planta.Pantalla_Plantas;
import Interface.Pantalla_Principal;
import Interface.ruta.Pantalla_Rutas;

import javax.swing.*;

public class Gestor_Pantalla {
    //pantalla principal
    private static final JFrame pantalla_principal = new Pantalla_Principal();
    //pantallas secundarias accedidas mediante botones de la pantalla principal
    private static final JFrame pantalla_plantas = new Pantalla_Plantas();
    private static final JFrame pantalla_camiones = new Pantalla_Camion();
    private static final JFrame pantalla_rutas = new Pantalla_Rutas();
    private static final JFrame pantalla_insumos = new Pantalla_Insumo();
    private static final JFrame pantalla_ordenes = new Pantalla_Ordenes();
    private static final JFrame pantalla_analisisPlantas = new Pantalla_AnalisisPlantas();

    public static void visualizarPantalla_principal(){
        pantalla_principal.setVisible(true);
    }
    public static void noVisualizarPantalla_principal(){
        pantalla_principal.setVisible(false);
    }

    public static void visualizarPantalla_plantas(){
        pantalla_plantas.setVisible(true);
    }
    public static void noVisualizarPantalla_plantas(){
        pantalla_plantas.setVisible(false);
    }

    public static void visualizarPantalla_camiones(){pantalla_camiones.setVisible(true);}
    public static void noVisualizarPantalla_camiones(){pantalla_camiones.setVisible(false);}

    public static void visualizarPantalla_rutas(){pantalla_rutas.setVisible(true);}
    public static void noVisualizarPantalla_rutas(){pantalla_rutas.setVisible(false);}

    public static void visualizarPantalla_insumos(){pantalla_insumos.setVisible(true);}
    public static void noVisualizarPantalla_insumos(){pantalla_insumos.setVisible(false);}

    public static void visualizarPantalla_ordenes(){pantalla_ordenes.setVisible(true);}
    public static void noVisualizarPantalla_ordenes(){pantalla_ordenes.setVisible(false);}

    public static void visualizarPantalla_analisisPlantas(){pantalla_analisisPlantas.setVisible(true);}
    public static void noVisualizarPantalla_analisisPlantas(){pantalla_analisisPlantas.setVisible(false);}


}
