package Interface.planta;

import Interface.ActionListenerAtras;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Plantas extends JFrame{
    public Pantalla_Plantas(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel volver = new JPanel();
            volver.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
            JButton atras = new JButton("<-- VOLVER");
            atras.addActionListener(new ActionListenerAtras());
            volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
    }
}
