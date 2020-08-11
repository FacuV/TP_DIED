package Interface.camion;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Negocio.Camion;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Pantalla_Camion extends JFrame {
    public Pantalla_Camion(){
        //titulo de la ventana
        super("Sistema de gestion logística - TP DIED 2020 ");
        //tamaño de la ventana
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        //pantalla completa por defecto
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //provoca que el programa se cierre al cerrarse la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sin ubicacion relativa, osea ubicacion en el centro de la pantalla
        setLocationRelativeTo(null);
        //Variable que sirve para modificar el frame
        Container cp = getContentPane();
        //set color
        cp.setBackground(Color.white);
        //set layout
        cp.setLayout(new BorderLayout());
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosCamiones(null,null,null,null,null,null),new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"}));
            JPanel panelComboBoxBotones = new JPanel(new GridLayout(11,1,0,15));
            JLabel buscarPor = new JLabel("BUSCAR POR");
            panelComboBoxBotones.add(buscarPor);
            JComboBox patentes = new JComboBox();
            patentes.addItem("PATENTE");
            JComboBox modelos = new JComboBox();
            modelos.addItem("MODELO");
            JComboBox kmRecorridos = new JComboBox();
            kmRecorridos.addItem("KM RECORRIDOS");
            JComboBox costoXkm = new JComboBox();
            costoXkm.addItem("COSTO POR KM");
            JComboBox costoXhora = new JComboBox();
            costoXhora.addItem("COSTO POR HORA");
            JComboBox fechaCompra = new JComboBox();
            fechaCompra.addItem("FECHA COMPRA");
            for (Camion camion:Gestor_Camiones.getCamiones().toArray(new Camion[0])){
                patentes.addItem(camion.getPatente());
                modelos.addItem(camion.getModelo());
                kmRecorridos.addItem(camion.getKm_recorridos());
                costoXkm.addItem(camion.getCosto_km());
                costoXhora.addItem(camion.getCosto_hora());
                fechaCompra.addItem(camion.getFecha_compra());
            }
            panelComboBoxBotones.add(patentes);
            panelComboBoxBotones.add(modelos);
            panelComboBoxBotones.add(kmRecorridos);
            panelComboBoxBotones.add(costoXkm);
            panelComboBoxBotones.add(costoXhora);
            panelComboBoxBotones.add(fechaCompra);
            JButton agregarCamion = new JButton("AGREGAR CAMIÓN");
            panelComboBoxBotones.add(agregarCamion);
            agregarCamion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame frame = new PantallaAñadirCamion();
                    frame.setVisible(true);
                }
            });
            JButton editar = new JButton("EDITAR");
            panelComboBoxBotones.add(editar);
            editar.setEnabled(false);
            JButton eliminar = new JButton("ELIMINAR");
            eliminar.setEnabled(false);
            editar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editar.setEnabled(false);
                    eliminar.setEnabled(false);
                    String patente = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(),0);
                    JFrame frame = new PantallaEditarCamion(Gestor_Camiones.getCamion(patente));
                    frame.setVisible(true);
                }
            });
            eliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminar.setEnabled(false);
                    editar.setEnabled(false);
                    String patenteSelected = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(),0);
                    try {
                        Gestor_Camiones.baja(patenteSelected);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    String patente = (patentes.getSelectedItem().toString().contentEquals("PATENTE"))?null:patentes.getSelectedItem().toString();
                    String modelo = (modelos.getSelectedItem().toString().contentEquals("MODELO"))?null:modelos.getSelectedItem().toString();
                    String kmRec = (kmRecorridos.getSelectedItem().toString().contentEquals("KM RECORRIDOS"))?null:kmRecorridos.getSelectedItem().toString();
                    String costoKm = (costoXkm.getSelectedItem().toString().contentEquals("COSTO POR KM"))?null:costoXkm.getSelectedItem().toString();
                    String costoHora = (costoXhora.getSelectedItem().toString().contentEquals("COSTO POR HORA"))?null:costoXhora.getSelectedItem().toString();
                    String fechaC = (fechaCompra.getSelectedItem().toString().contentEquals("FECHA COMPRA"))?null:fechaCompra.getSelectedItem().toString();
                    tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosCamiones(patente,modelo,kmRec,costoKm,costoHora,fechaC),new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"}));
                    revalidate();

                }
            });
            panelComboBoxBotones.add(eliminar);
            JButton actualizar = new JButton("ACTUALIZAR");
            actualizar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminar.setEnabled(false);
                    editar.setEnabled(false);
                    String patente = (patentes.getSelectedItem().toString().contentEquals("PATENTE"))?null:patentes.getSelectedItem().toString();
                    String modelo = (modelos.getSelectedItem().toString().contentEquals("MODELO"))?null:modelos.getSelectedItem().toString();
                    String kmRec = (kmRecorridos.getSelectedItem().toString().contentEquals("KM RECORRIDOS"))?null:kmRecorridos.getSelectedItem().toString();
                    String costoKm = (costoXkm.getSelectedItem().toString().contentEquals("COSTO POR KM"))?null:costoXkm.getSelectedItem().toString();
                    String costoHora = (costoXhora.getSelectedItem().toString().contentEquals("COSTO POR HORA"))?null:costoXhora.getSelectedItem().toString();
                    String fechaC = (fechaCompra.getSelectedItem().toString().contentEquals("FECHA COMPRA"))?null:fechaCompra.getSelectedItem().toString();
                    tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosCamiones(patente,modelo,kmRec,costoKm,costoHora,fechaC),new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"}));
                    revalidate();
                }
            });
            panelComboBoxBotones.add(actualizar);
            tabla.getSelectionModel().addListSelectionListener(e -> {editar.setEnabled(true);eliminar.setEnabled(true);});
        cp.add(new JScrollPane(tabla),BorderLayout.CENTER);
            ActionListener ActionListenerCB = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String patente = (patentes.getSelectedItem().toString().contentEquals("PATENTE"))?null:patentes.getSelectedItem().toString();
                    String modelo = (modelos.getSelectedItem().toString().contentEquals("MODELO"))?null:modelos.getSelectedItem().toString();
                    String kmRec = (kmRecorridos.getSelectedItem().toString().contentEquals("KM RECORRIDOS"))?null:kmRecorridos.getSelectedItem().toString();
                    String costoKm = (costoXkm.getSelectedItem().toString().contentEquals("COSTO POR KM"))?null:costoXkm.getSelectedItem().toString();
                    String costoHora = (costoXhora.getSelectedItem().toString().contentEquals("COSTO POR HORA"))?null:costoXhora.getSelectedItem().toString();
                    String fechaC = (fechaCompra.getSelectedItem().toString().contentEquals("FECHA COMPRA"))?null:fechaCompra.getSelectedItem().toString();
                    tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosCamiones(patente,modelo,kmRec,costoKm,costoHora,fechaC),new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"}));
                    revalidate();
                }
            };
            patentes.addActionListener(ActionListenerCB);
            modelos.addActionListener(ActionListenerCB);
            kmRecorridos.addActionListener(ActionListenerCB);
            costoXkm.addActionListener(ActionListenerCB);
            costoXhora.addActionListener(ActionListenerCB);
            fechaCompra.addActionListener(ActionListenerCB);
        cp.add(panelComboBoxBotones,BorderLayout.WEST);
        JPanel volver = new JPanel();
        volver.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
        JButton atras = new JButton("<-- VOLVER");
        atras.addActionListener(new ActionListenerAtras());
        volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
    }
}


