package Interface.camion;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Camion extends JFrame {
    public Pantalla_Camion(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.add(new JLabel("pantalla de camion"));
    }
}
