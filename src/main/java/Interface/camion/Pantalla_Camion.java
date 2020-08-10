package Interface.camion;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Negocio.Camion;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.*;

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
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosCamiones(),new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"}));
            JPanel panelComboBoxBotones = new JPanel(new GridLayout(10,1,0,20));
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
        cp.add(new JScrollPane(tabla),BorderLayout.CENTER);
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


