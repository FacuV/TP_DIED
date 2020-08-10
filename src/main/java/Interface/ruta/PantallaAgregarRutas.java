package Interface.ruta;

import Negocio.Planta;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PantallaAgregarRutas extends JFrame{
    public PantallaAgregarRutas(){
        super("Pantalla Agregar Rutas");
        setSize((int) ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3), (int) ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/3));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel panelInfo = new JPanel(new GridLayout(5,2));
                JLabel plantaOrigen = new JLabel("PLANTA ORIGEN");
                panelInfo.add(plantaOrigen);
                JComboBox<Planta> plantaOrigenCB = new JComboBox();
                for(Planta plantaO:Gestor_Plantas.getPlantas()){plantaOrigenCB.addItem(plantaO);}
                panelInfo.add(plantaOrigenCB);
                JLabel plantaDestino = new JLabel("PLANTA DESTINO");
                panelInfo.add(plantaDestino);
                JComboBox<Planta> plantaDestinoCB = new JComboBox();
                for(Planta plantaD:Gestor_Plantas.getPlantas()){plantaDestinoCB.addItem(plantaD);}
                panelInfo.add(plantaDestinoCB);
                JLabel distancia = new JLabel("DISTANCIA");
                panelInfo.add(distancia);
                JTextField distanciaTextfield = new JTextField(50);
                panelInfo.add(distanciaTextfield);
                JLabel duracion = new JLabel("DURACION");
                panelInfo.add(duracion);
                JTextField duracionTextField = new JTextField(50);
                panelInfo.add(duracionTextField);
                JLabel pesoMax = new JLabel("PESO MAX");
                panelInfo.add(pesoMax);
                JTextField pesoMaxTextField = new JTextField(50);
                panelInfo.add(pesoMaxTextField);
                JButton boton = new JButton("GUARDAR");
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Gestor_Plantas.conectar((Planta) plantaOrigenCB.getSelectedItem(),(Planta)plantaDestinoCB.getSelectedItem(),Double.parseDouble(distanciaTextfield.getText()),Integer.parseInt(duracionTextField.getText()),Double.parseDouble(pesoMaxTextField.getText()));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        dispose();
                    }
                });
        cp.add(panelInfo,BorderLayout.CENTER);
        cp.add(boton,BorderLayout.SOUTH);
    }
}
