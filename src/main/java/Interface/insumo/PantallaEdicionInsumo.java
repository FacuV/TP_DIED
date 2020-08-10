package Interface.insumo;

import Negocio.Insumo;

import javax.swing.*;
import java.awt.*;

public class PantallaEdicionInsumo extends JFrame {
    public PantallaEdicionInsumo(Insumo insumo){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
    }
}
