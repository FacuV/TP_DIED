package Interface.planta;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Negocio.Planta;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Plantas extends JFrame{
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
            botones.setLayout(new GridLayout(7,1,0,10));
                JButton agregarPlanta = new JButton("AGREGAR PLANTA");
                botones.add(agregarPlanta);
                agregarPlanta.addActionListener(new ActionListenerAgregarPlanta());
                JButton flujoMax = new JButton("FLUJO MAXIMO");
                botones.add(flujoMax);
                flujoMax.addActionListener(new ActionListenerFlujoMaximo());
                JButton pageRank = new JButton("PAGE RANK");
                botones.add(pageRank);
                pageRank.addActionListener(new ActionListenerPageRank());
                JButton caminosMinimos = new JButton("CAMINOS MINIMOS");
                botones.add(caminosMinimos);
                caminosMinimos.addActionListener(new ActionListenerCaminosMinimos());
                JButton bajoPuntoReposicion = new JButton("BAJO PUNTO REPOSICION");
                botones.add(bajoPuntoReposicion);
                bajoPuntoReposicion.addActionListener(new ActionListenerBajoPuntoReposicion());
                JButton agregarStock = new JButton("AGREGAR STOCK");
                botones.add(agregarStock);
                agregarStock.setEnabled(false);
                JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizPlantas(null), new String[]{"ID PLANTA","NOMBRE"}));
                tabla.getSelectionModel().addListSelectionListener(e -> agregarStock.setEnabled(true));
                agregarStock.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idOnombre = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(),0);
                        Planta planta;
                        int id = Integer.parseInt(idOnombre);
                        planta = Gestor_Plantas.getPlanta(id);
                        JFrame frame = new PantallaAgregarStock(planta);
                        frame.setVisible(true);
                    }
                });
                JButton actualizar = new JButton("ACTUALIZAR");
                botones.add(actualizar);
                actualizar.addActionListener(new ActionListener() {
                     @Override
                    public void actionPerformed(ActionEvent e) {
                         agregarStock.setEnabled(false);
                         tabla.setModel(new ModeloTabla(Gestor_Pantalla.getMatrizPlantas(null), new String[]{"ID PLANTA","NOMBRE"}));
                         revalidate();
                    }
                });

            GridBagConstraints gbcBotones = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20);
            aux.add(botones,gbcBotones);
            JPanel panelTabla = new JPanel();
            panelTabla.setLayout(new GridBagLayout());
            panelTabla.setBackground(Color.white);
                JPanel auxBusqueda = new JPanel();
                auxBusqueda.setBackground(Color.white);
                auxBusqueda.setLayout(new FlowLayout());
                        JLabel busqueda = new JLabel("BUSQUEDA POR NOMBRE: ");
                        JTextField textField = new JTextField(80);
                        JButton buscar = new JButton("BUSCAR");
                        buscar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                agregarStock.setEnabled(false);
                                tabla.setModel(new ModeloTabla(Gestor_Pantalla.getMatrizPlantas(null), new String[]{"ID PLANTA","NOMBRE"}));
                                revalidate();
                            }
                        });
                auxBusqueda.add(busqueda);auxBusqueda.add(textField);auxBusqueda.add(buscar);
            panelTabla.add(auxBusqueda,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,0,0,0),20,20));
            panelTabla.add(new JScrollPane(tabla), new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(100,50,30,50),20,20));
            JPanel volver = new JPanel();
            volver.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
            JButton atras = new JButton("<-- VOLVER");
            atras.addActionListener(new ActionListenerAtras());
            volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
        cp.add(aux,BorderLayout.WEST);
        cp.add(panelTabla,BorderLayout.CENTER);
    }
}
