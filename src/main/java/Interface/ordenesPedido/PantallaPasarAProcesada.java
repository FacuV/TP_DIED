package Interface.ordenesPedido;

import Negocio.Orden_Pedido;
import Negocio.Planta;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PantallaPasarAProcesada extends JFrame{
    public PantallaPasarAProcesada(Orden_Pedido ordenPedido) throws SQLException, InterruptedException {
        super("Pasar a Procesada");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
        List<Planta> plantaConStock = Gestor_Plantas.plantasConStock(ordenPedido);
        if(plantaConStock.isEmpty()){
            JLabel alerta = new JLabel("NO SE PUEDE LLEVAR A CABO ESTA ORDEN DE PEDIDO, LA ORDEN SE CANCELA");
            cp.add(alerta,BorderLayout.CENTER);
            Gestor_Ordenes_Pedido.pasarACancelada(ordenPedido);
            wait(5000);
            dispose();
        }else{
            JPanel panelCB = new JPanel(new FlowLayout());
                JComboBox<Planta> plantasCB = new JComboBox<>();
                for (Planta planta:plantaConStock){plantasCB.addItem(planta);}
                panelCB.add(plantasCB);
                JComboBox<List<Planta>> rutasCB = new JComboBox<>();
                for (List<Planta> plantaList:Gestor_Plantas.caminosMasCortos((Planta) plantasCB.getSelectedItem(),ordenPedido.getPlanta_destino())){
                    rutasCB.addItem(plantaList);
                }
                panelCB.add(rutasCB);
                plantasCB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rutasCB.removeAllItems();
                        for (List<Planta> plantaList:Gestor_Plantas.caminosMasCortos((Planta) plantasCB.getSelectedItem(),ordenPedido.getPlanta_destino())){
                            rutasCB.addItem(plantaList);
                        }
                        revalidate();
                    }
                });
            cp.add(panelCB,BorderLayout.CENTER);
            JButton aceptar = new JButton("ACEPTAR");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Gestor_Ordenes_Pedido.pasarAProcesada(ordenPedido,Gestor_Plantas.plantasARutas((ArrayList<Planta>) rutasCB.getSelectedItem()));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    dispose();
                }
            });
            cp.add(aceptar,BorderLayout.SOUTH);
        }
    }
}
