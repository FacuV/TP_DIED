package Interface.camion;

import Interface.ActionListenerAtras;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Camion extends JFrame {
    public Pantalla_Camion(){
        //titulo de la ventana
        super("Sistema de gestion logística - TP DIED 2020 ");
        //tamaño de la ventana
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        //pantalla completa por defecto
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //provoca que el programa se cierre al cerrarse la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sin ubicacion relativa, osea ubicacion en el centro de la pantalla
        setLocationRelativeTo(null);
        //Variable que sirve para modificar el frame
        Container cp = getContentPane();
        //set color
        cp.setBackground(Color.white);
        //set layout
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


