package Interface.planta;

import Negocio.Insumo;
import Negocio.Planta;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PantallaAgregarStock extends JFrame {
    public PantallaAgregarStock(Planta planta){
        super("Agregar Stock a "+planta.toString());
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3,2));
                JLabel insumo = new JLabel("INSUMO");
                panel.add(insumo);
                JComboBox insumos = new JComboBox();
                    insumos.addItem("INSUMO");
                    for(Insumo unInsumo:Gestor_Insumos.getInsumos()){
                        insumos.addItem(unInsumo);
                    }
                panel.add(insumos);
                JLabel cantidad = new JLabel("CANTIDAD");
                panel.add(cantidad);
                JTextField cantidadJText = new JTextField(20);
                panel.add(cantidadJText);
                JLabel puntoPedido = new JLabel("PUNTO DE PEDIDO");
                panel.add(puntoPedido);
                JTextField puntoPedidoJText = new JTextField(20);
                panel.add(puntoPedidoJText);
        cp.add(panel);
        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gestor_Plantas.actualizarStock(planta.getId(),(Insumo) insumos.getSelectedItem(),Integer.parseInt(cantidadJText.getText()),Integer.parseInt(puntoPedidoJText.getText()));
                    setVisible(false);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        cp.add(aceptar,BorderLayout.SOUTH);
    }
}
