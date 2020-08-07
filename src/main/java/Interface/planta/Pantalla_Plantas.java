package Interface.planta;

import Interface.ActionListenerAtras;
import Servicio.Gestor_Pantalla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Pantalla_Plantas extends JFrame{
    JTable table = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizPlantas(null), new String[]{"ID PLANTA","NOMBRE"}));
    public Pantalla_Plantas(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel aux = new JPanel();
            aux.setLayout(new GridBagLayout());
            aux.setBackground(Color.white);
            JPanel botones = new JPanel();
            botones.setBackground(Color.white);
            botones.setLayout(new GridLayout(6,1,0,10));
                JButton agregarPlanta = new JButton("AGREGAR PLANTA");
                JButton flujoMax = new JButton("FLUJO MAXIMO");
                JButton pageRank = new JButton("PAGE RANK");
                JButton caminosMinimos = new JButton("CAMINOS MINIMOS");
                JButton bajoPuntoReposicion = new JButton("BAJO PUNTO REPOSICION");
                JButton agregarStock = new JButton("AGREGAR STOCK");
                agregarStock.setEnabled(false);
                botones.add(agregarPlanta);botones.add(flujoMax);
                botones.add(pageRank);botones.add(caminosMinimos);
                botones.add(bajoPuntoReposicion);botones.add(agregarStock);
            GridBagConstraints gbcBotones = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20);
            aux.add(botones,gbcBotones);
            JPanel tabla = new JPanel();
            tabla.setLayout(new GridBagLayout());
            tabla.setBackground(Color.white);
            tabla.add(new JTextField("nombre de planta"),new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,50,20,50),20,20));
            tabla.add(new JScrollPane(table), new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,25,20,25),20,20));


            JPanel volver = new JPanel();
            volver.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
            JButton atras = new JButton("<-- VOLVER");
            atras.addActionListener(new ActionListenerAtras());
            volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
        cp.add(aux,BorderLayout.WEST);
        cp.add(tabla,BorderLayout.CENTER);
    }
    public void setTable(){

    }
}
