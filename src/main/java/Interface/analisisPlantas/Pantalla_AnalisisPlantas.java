package Interface.analisisPlantas;

import javax.swing.*;
import java.awt.*;

public class Pantalla_AnalisisPlantas extends JFrame {
    public Pantalla_AnalisisPlantas(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.add(new JLabel("pantalla de analisis"));
    }
}
