package Interface;

import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerPlanta implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Gestor_Pantalla.visualizarPantalla_plantas();
        Gestor_Pantalla.noVisualizarPantalla_principal();
    }
}
