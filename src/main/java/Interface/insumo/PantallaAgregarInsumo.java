package Interface.insumo;

import Servicio.Gestor_Insumos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PantallaAgregarInsumo extends JFrame {
    public PantallaAgregarInsumo(JTable tabla){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel info = new JPanel(new GridLayout(5,2));
            JLabel descripcion = new JLabel("DESCRIPCIÓN");
            info.add(descripcion);
            JTextField descripcionTextField = new JTextField(50);
            info.add(descripcionTextField);
            JLabel unidadMedida = new JLabel("UNIDAD DE MEDIDA");
            info.add(unidadMedida);
            JTextField unidadMedidaTextField = new JTextField(50);
            info.add(unidadMedidaTextField);
            JLabel costo = new JLabel("COSTO");
            info.add(costo);
            JTextField costoTextField = new JTextField(50);
            info.add(costoTextField);
            JLabel insumo = new JLabel("INSUMO");
            info.add(insumo);
            JPanel panelCheckBox = new JPanel(new FlowLayout());
                JCheckBox general = new JCheckBox("GENERAL");
                JCheckBox liquido = new JCheckBox("LIQUIDO");
                general.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(general.isSelected()){
                            liquido.setSelected(false);
                        }
                    }
                });
                liquido.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                         if(liquido.isSelected()){
                             general.setSelected(false);
                         }
                   }
                });
            panelCheckBox.add(general);panelCheckBox.add(liquido);
            info.add(panelCheckBox);
            JLabel pesoDensidad = new JLabel("PESO/DENSIDAD");
            info.add(pesoDensidad);
            JTextField pesoDensidadTextField = new JTextField(50);
            info.add(pesoDensidadTextField);
        cp.add(info,BorderLayout.CENTER);
            JButton aceptar = new JButton("ACEPTAR");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (general.isSelected()) {
                            Gestor_Insumos.registrarInsumoG(descripcionTextField.getText(), unidadMedidaTextField.getText(), Double.valueOf(costoTextField.getText()), Double.valueOf(pesoDensidadTextField.getText()));
                        } else {
                            Gestor_Insumos.registrarInsumoL(descripcionTextField.getText(), unidadMedidaTextField.getText(), Double.valueOf(costoTextField.getText()), Double.valueOf(pesoDensidadTextField.getText()));
                        }
                    }catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    dispose();
                }
            });
        cp.add(aceptar,BorderLayout.SOUTH);
    }
}
