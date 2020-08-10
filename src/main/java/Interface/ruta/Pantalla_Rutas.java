package Interface.ruta;

import Interface.ActionListenerAtras;
import Interface.ModeloTabla;
import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Rutas extends JFrame{
    public Pantalla_Rutas(){
        super("Sistema de gestion logística - TP DIED 2020 ");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosRutas(),new String[]{"PLANTA ORIGEN","PLANTA DESTINO", "DISTANCIA", "DURACION", "PESO MAX"}));
            JPanel panelBotones = new JPanel(new GridLayout(2,1,10,50));
                JButton agregarRuta = new JButton("AGREGAR RUTA");
                panelBotones.add(agregarRuta);
                JButton actualizar = new JButton("ACTUALIZAR");
                panelBotones.add(actualizar);
                agregarRuta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new PantallaAgregarRutas();
                        frame.setVisible(true);
                    }
                });
                actualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tabla.setModel(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosRutas(),new String[]{"PLANTA ORIGEN","PLANTA DESTINO", "DISTANCIA", "DURACION", "PESO MAX"}));
                        revalidate();
                    }
                });
        cp.add(panelBotones,BorderLayout.WEST);
        cp.add(new JScrollPane(tabla),BorderLayout.CENTER);
        JPanel volver = new JPanel();
        volver.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.SOUTHWEST,GridBagConstraints.CENTER,new Insets(0,5,5,0),20,20);
        JButton atras = new JButton("<-- VOLVER");
        atras.addActionListener(new ActionListenerAtras());
        volver.add(atras,gbc);
        cp.add(volver,BorderLayout.SOUTH);
    }
}
