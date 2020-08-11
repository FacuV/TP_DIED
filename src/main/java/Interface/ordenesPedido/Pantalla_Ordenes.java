package Interface.ordenesPedido;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Interface.camion.PantallaAñadirCamion;
import Interface.camion.PantallaEditarCamion;
import Negocio.Camion;
import Negocio.Estado;
import Negocio.Orden_Pedido;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Pantalla;
import com.amazonaws.services.dynamodbv2.xspec.M;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Pantalla_Ordenes extends JFrame {
    public Pantalla_Ordenes(){
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
        JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosOrdenes(null),new String[]{"NUMERO","PLANTA DESTINO","ESTADO","FECHA SOLICITUD","FECHA MAX ENTREGA"}));
        JPanel panelComboBoxBotones = new JPanel(new GridLayout(4,1,0,15));
        JLabel buscarPor = new JLabel("BUSCAR POR");
        panelComboBoxBotones.add(buscarPor);
        JComboBox estados = new JComboBox();
        estados.addItem("ESTADO");
        for (Estado estado: Estado.values()){
            estados.addItem(estado);
        }
        estados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosOrdenes(estados.getSelectedItem().toString()),new String[]{"NUMERO","PLANTA DESTINO","ESTADO","FECHA SOLICITUD","FECHA MAX ENTREGA"}));
                revalidate();
            }
        });
        panelComboBoxBotones.add(estados);
        JButton crearOrden = new JButton("CREAR ORDEN");
        panelComboBoxBotones.add(crearOrden);
        crearOrden.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //JFrame frame = new PantallaCrearOrden();
                //frame.setVisible(true);
            }
        });
        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosOrdenes((estados.getSelectedItem().toString().contentEquals("ESTADO"))?null:estados.getSelectedItem().toString()),new String[]{"NUMERO","PLANTA DESTINO","ESTADO","FECHA SOLICITUD","FECHA MAX ENTREGA"}));
                revalidate();
            }
        });
        panelComboBoxBotones.add(actualizar);
        //tabla.getSelectionModel().addListSelectionListener(e -> {editar.setEnabled(true);eliminar.setEnabled(true);});
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
