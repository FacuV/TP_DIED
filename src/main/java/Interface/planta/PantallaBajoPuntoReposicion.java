package Interface.planta;

import Interface.ModeloTabla;
import Negocio.Insumo;
import Negocio.Planta;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaBajoPuntoReposicion extends JFrame{
    public PantallaBajoPuntoReposicion(){
        super("Plantas Bajo Punto Reposicion");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new GridBagLayout());
            //JPanel auxTabla = new JPanel(new GridBagLayout());
            //auxTabla.setBackground(Color.white);
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizBajoPuntoReposicion(null,null),new String[]{"PLANTA", "INSUMO", "STOCK EN PLANTA", "PUNTO DE PEDIDO", "STOCK TOTAL"}));
            JScrollPane contenedor = new JScrollPane(tabla);
            //auxTabla.add(contenedor,new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),20,20));
            JPanel panelComboBox = new JPanel(new FlowLayout());
                JLabel buscarPor = new JLabel(" BUSCAR POR: ");
                JComboBox plantas = new JComboBox();
                JComboBox insumos = new JComboBox();
                plantas.addItem("PLANTA");
                insumos.addItem("INSUMO");
                for (List list: Gestor_Plantas.plantasInsumoBajoPuntoReposicion()){insumos.addItem(list.get(1));}
                for (Planta p:Gestor_Plantas.plantasBajoPuntoReposicion()){plantas.addItem(p);}
                plantas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cp.remove(1);
                        cp.add(new JScrollPane(new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizBajoPuntoReposicion((plantas.getSelectedItem() instanceof String)?null:(Planta) plantas.getSelectedItem(),(insumos.getSelectedItem() instanceof String)?null:(Insumo) insumos.getSelectedItem()),new String[]{"PLANTA", "INSUMO", "STOCK EN PLANTA", "PUNTO DE PEDIDO", "STOCK TOTAL"}))),new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.EAST,GridBagConstraints.BOTH,new Insets(10, (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4.1),10,10),20,20));
                        revalidate();
                    }
                });
                insumos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cp.remove(1);
                        cp.add(new JScrollPane(new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizBajoPuntoReposicion((plantas.getSelectedItem() instanceof String)?null:(Planta) plantas.getSelectedItem(),(insumos.getSelectedItem() instanceof String)?null:(Insumo) insumos.getSelectedItem()),new String[]{"PLANTA", "INSUMO", "STOCK EN PLANTA", "PUNTO DE PEDIDO", "STOCK TOTAL"}))),new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.EAST,GridBagConstraints.BOTH,new Insets(10, (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4.1),10,10),20,20));
                        revalidate();
                    }
                });
            panelComboBox.add(buscarPor);panelComboBox.add(plantas);panelComboBox.add(insumos);
        cp.add(panelComboBox,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.WEST,GridBagConstraints.VERTICAL,new Insets(20,0,0,0),20,20));
        cp.add(contenedor,new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.EAST,GridBagConstraints.BOTH,new Insets(10, (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4.1),10,10),20,20));
    }
}
