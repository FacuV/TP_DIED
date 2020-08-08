package Interface.planta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerFlujoMaximo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame flujoPrincipal = new PantallaFlujoMaximo();
        flujoPrincipal.setVisible(true);
    }
}
