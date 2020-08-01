package Servicio;

import Interface.Pantalla_Plantas;
import Interface.Pantalla_Principal;

import javax.swing.*;

public class Gestor_Pantalla {
    private  static JFrame pantalla_principal = new Pantalla_Principal();
    private  static JFrame pantalla_plantas = new Pantalla_Plantas();
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
}
