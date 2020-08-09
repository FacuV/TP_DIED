package Interface.planta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerBajoPuntoReposicion implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new PantallaBajoPuntoReposicion();
        frame.setVisible(true);
    }
}
