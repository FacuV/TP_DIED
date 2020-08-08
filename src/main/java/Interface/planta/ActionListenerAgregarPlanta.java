package Interface.planta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAgregarPlanta implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame agregarPlanta = new PantallaAgregarPlanta();
        agregarPlanta.setVisible(true);
    }
}
