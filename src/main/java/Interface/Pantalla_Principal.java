package Interface;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Principal extends JFrame {
    public Pantalla_Principal(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,1));
            JPanel panelTitulo = new JPanel();
                panelTitulo.setLayout(new GridBagLayout());
                panelTitulo.setBackground(Color.white);
                JLabel principal = new JLabel("SISTEMA DE GESTIÓN LOGÍSTICA");
                panelTitulo.add(principal);
                principal.setFont(new Font(Font.DIALOG,1,40));

            JPanel aux = new JPanel();
            aux.setLayout(new GridBagLayout());
            aux.setBackground(Color.white);
            JPanel subPanelBotones = new JPanel();

                subPanelBotones.setLayout(new GridLayout(6,1,0,10));
                subPanelBotones.setBackground(Color.white);
                JButton plantas = new JButton("PLANTAS");
                plantas.addActionListener(new ActionListenerPlanta());
                JButton camiones = new JButton("CAMIONES");
                camiones.addActionListener(new ActionListenerCamion());
                JButton rutas = new JButton("RUTAS");
                rutas.addActionListener(new ActionListenerRuta());
                JButton insumos = new JButton("INSUMOS");
                insumos.addActionListener(new ActionListenerInsumo());
                JButton ordenes = new JButton("ORDENES DE PEDIDO");
                ordenes.addActionListener(new ActionListenerOrdenesPedido());
                JButton analisis_plantas = new JButton("ANALISIS DE PLANTAS");
                analisis_plantas.addActionListener(new ActionListenerAnalisisPlantas());
                subPanelBotones.add(plantas); subPanelBotones.add(rutas);
                subPanelBotones.add(camiones); subPanelBotones.add(insumos);
                subPanelBotones.add(ordenes); subPanelBotones.add(analisis_plantas);
            GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(0,0,20,0),20,20);
            aux.add(subPanelBotones,gbc);

        cp.add(panelTitulo);
        cp.add(aux);




    }
}
