package Interface.planta;

import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PantallaAgregarPlanta extends JFrame{
    public PantallaAgregarPlanta(){
        super("Agregar Planta");
        setSize((int) ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3), (int) ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/3));
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel aux = new JPanel();
            aux.setLayout(new FlowLayout());
            JLabel label = new JLabel("NOMBRE: ");
            JTextField textPane = new JTextField(40);
            JButton boton = new JButton("GUARDAR");
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Gestor_Plantas.registrarPlanta(textPane.getText());

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    dispose();
                }
            });
            aux.add(label);aux.add(textPane);
        cp.add(aux,BorderLayout.CENTER);cp.add(boton,BorderLayout.SOUTH);
    }
}
