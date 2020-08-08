package Interface.planta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerPageRank implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new PantallaPageRank();
        frame.setVisible(true);
    }
}
