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
    JTable table = setTable(null);
    JScrollPane scrollPane;
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
                agregarPlanta.addActionListener(new ActionListenerAgregarPlanta());
                JButton flujoMax = new JButton("FLUJO MAXIMO");
                flujoMax.addActionListener(new ActionListenerFlujoMaximo());
                JButton pageRank = new JButton("PAGE RANK");
                pageRank.addActionListener(new ActionListenerPageRank());
                JButton caminosMinimos = new JButton("CAMINOS MINIMOS");
                caminosMinimos.addActionListener(new ActionListenerCaminosMinimos());
                JButton bajoPuntoReposicion = new JButton("BAJO PUNTO REPOSICION");
                bajoPuntoReposicion.addActionListener(new ActionListenerBajoPuntoReposicion());
                JButton agregarStock = new JButton("AGREGAR STOCK");
                agregarStock.setEnabled(false);
                agregarStock.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idOnombre = (String) table.getModel().getValueAt(table.getSelectedRow(),0);
                        Planta planta;
                        int id = Integer.parseInt(idOnombre);
                        planta = Gestor_Plantas.getPlanta(id);
                        JFrame frame = new PantallaAgregarStock(planta);
                        frame.setVisible(true);
                    }
                });
                botones.add(agregarPlanta);botones.add(flujoMax);
                botones.add(pageRank);botones.add(caminosMinimos);
                botones.add(bajoPuntoReposicion);botones.add(agregarStock);
            GridBagConstraints gbcBotones = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20);
            aux.add(botones,gbcBotones);
            JPanel tabla = new JPanel();
            tabla.setLayout(new GridBagLayout());
            tabla.setBackground(Color.white);
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
                                setTable(textField.getText());
                                tabla.remove(scrollPane);
                                table = setTable(textField.getText());
                                table.getSelectionModel().addListSelectionListener(i -> agregarStock.setEnabled(true));
                                JScrollPane scrollPaneAux = new JScrollPane(table);
                                tabla.add(scrollPaneAux, new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(100,50,30,50),20,20));
                                revalidate();
                            }
                        });
                auxBusqueda.add(busqueda);auxBusqueda.add(textField);auxBusqueda.add(buscar);
            tabla.add(auxBusqueda,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,0,0,0),20,20));
                scrollPane = new JScrollPane(table);
                //Activar el boton AgregarStock
                table.getSelectionModel().addListSelectionListener(e -> agregarStock.setEnabled(true));
            tabla.add(scrollPane, new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(100,50,30,50),20,20));
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
    public JTable setTable(String nombrePlanta){
        JTable table = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizPlantas(nombrePlanta), new String[]{"ID PLANTA","NOMBRE"}));
        return table;
    }
}
