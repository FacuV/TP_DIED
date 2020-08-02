package Interface;

import Servicio.Gestor_Pantalla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAnalisisPlantas implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Gestor_Pantalla.visualizarPantalla_analisisPlantas();
    }
}