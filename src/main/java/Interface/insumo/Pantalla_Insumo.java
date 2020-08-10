package Interface.insumo;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Interface.planta.PantallaAgregarStock;
import Negocio.Insumo;
import Negocio.Planta;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Pantalla_Insumo extends JFrame {
    public Pantalla_Insumo(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JPanel panelBotones = new JPanel(new GridLayout(4,1,10,20));
                JButton agregarInsumo = new JButton("AGREGAR INSUMO");
                panelBotones.add(agregarInsumo);
                JButton editar = new JButton("EDITAR");
                editar.setEnabled(false);
                panelBotones.add(editar);
                JButton eliminar = new JButton("ELIMINAR");
                eliminar.setEnabled(false);
                panelBotones.add(eliminar);
                JButton actualizar = new JButton("ACTUALIZAR");
                panelBotones.add(actualizar);
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosInsumos(),new String[]{"ID","DESCRPCION", "UNIDAD DE MEDIDA", "COSTO", "PESO/DENSIDAD", "STOCK TOTAL"}));
            tabla.getSelectionModel().addListSelectionListener(e -> {editar.setEnabled(true);eliminar.setEnabled(true);});
            JScrollPane contenedor = new JScrollPane(tabla);
                editar.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         String idOnombre = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(),0);
                         Insumo insumo;
                         int id = Integer.parseInt(idOnombre);
                         insumo = Gestor_Insumos.getInsumo(id);
                         JFrame frame = new PantallaEdicionInsumo(insumo);
                         frame.setVisible(true);
                         tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosInsumos(),new String[]{"ID","DESCRPCION", "UNIDAD DE MEDIDA", "COSTO", "PESO/DENSIDAD", "STOCK TOTAL"}));
                         revalidate();
                        }
                });
                eliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idOnombre = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(),0);
                        int id = Integer.parseInt(idOnombre);
                        try {
                            Gestor_Insumos.baja(id);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosInsumos(),new String[]{"ID","DESCRPCION", "UNIDAD DE MEDIDA", "COSTO", "PESO/DENSIDAD", "STOCK TOTAL"}));
                        revalidate();
                    }
                });
                agregarInsumo.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JFrame frame = new PantallaAgregarInsumo();
                         frame.setVisible(true);
                     }
                });
                actualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosInsumos(),new String[]{"ID","DESCRPCION", "UNIDAD DE MEDIDA", "COSTO", "PESO/DENSIDAD", "STOCK TOTAL"}));
                        revalidate();
                    }
                });
        cp.add(panelBotones,BorderLayout.WEST);
        cp.add(contenedor,BorderLayout.CENTER);
        JPanel volver = new JPanel();
        volver.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
        JButton atras = new JButton("<-- VOLVER");
        atras.addActionListener(new ActionListenerAtras());
        volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
    }
}
