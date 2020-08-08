package Interface.planta;

import Negocio.Planta;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PantallaFlujoMaximo extends JFrame{
    JLabel km = new JLabel(" ");
    JPanel panelCentradorkm = new JPanel();
    JTable table = setTable(Gestor_Plantas.getPlanta(1),Gestor_Plantas.getPlanta(1));

    JPanel panelTabla = new JPanel();
    public PantallaFlujoMaximo(){
        super("Flujo Maximo");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setBackground(Color.white);
        cp.setLayout(new GridBagLayout());
            JPanel aux1 = new JPanel();
            aux1.setLayout(new GridLayout(3,1));
            aux1.setBackground(Color.white);
                JPanel centrar = new JPanel();
                centrar.setLayout(new GridBagLayout());
                centrar.setBackground(Color.white);
                JLabel titulo = new JLabel("FLUJO MAXIMO ENTRE");
                centrar.add(titulo,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20));
            aux1.add(centrar);
                JPanel panelComboBox = new JPanel();
                panelComboBox.setLayout(new FlowLayout());
                panelComboBox.setBackground(Color.white);
                JComboBox<Planta> comboBox1 = new JComboBox<>();
                JComboBox<Planta> comboBox2 = new JComboBox<>();
                    for (Planta p : Gestor_Plantas.getPlantas()){
                        comboBox1.addItem(p);
                        comboBox2.addItem(p);
                    }
                comboBox1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        aux1.remove(panelCentradorkm);
                        panelTabla.remove(0);
                        panelTabla.add(new JScrollPane(setTable((Planta) comboBox1.getSelectedItem(),(Planta) comboBox2.getSelectedItem())));
                        revalidate();
                        String numFlujo = String.valueOf(Gestor_Plantas.flujoMaxNumero((Planta) comboBox1.getSelectedItem(),(Planta) comboBox2.getSelectedItem())) + " Kg";
                        km = new JLabel(numFlujo);
                        panelCentradorkm = new JPanel();
                        panelCentradorkm.setBackground(Color.white);
                        panelCentradorkm.setLayout(new GridBagLayout());
                        panelCentradorkm.add(km,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20));
                        aux1.add(panelCentradorkm);
                        aux1.revalidate();
                    }
                });
                comboBox2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        aux1.remove(panelCentradorkm);
                        panelTabla.remove(0);
                        panelTabla.add(new JScrollPane(setTable((Planta) comboBox1.getSelectedItem(),(Planta) comboBox2.getSelectedItem())));
                        revalidate();
                        String numFlujo = String.valueOf(Gestor_Plantas.flujoMaxNumero((Planta) comboBox1.getSelectedItem(),(Planta) comboBox2.getSelectedItem())) + " Kg";
                        km = new JLabel(numFlujo);
                        panelCentradorkm = new JPanel();
                        panelCentradorkm.setBackground(Color.white);
                        panelCentradorkm.setLayout(new GridBagLayout());
                        panelCentradorkm.add(km,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20));
                        aux1.add(panelCentradorkm);
                        aux1.revalidate();
                    }
                });
                panelComboBox.add(comboBox1);panelComboBox.add(new JLabel(" Y "));panelComboBox.add(comboBox2);
            aux1.add(panelComboBox);
            panelCentradorkm.setLayout(new GridBagLayout());
            panelCentradorkm.setBackground(Color.white);
            panelCentradorkm.add(km,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,0),20,20));
            aux1.add(panelCentradorkm);
        cp.add(aux1,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,50,0),20,20));
        panelTabla.setLayout(new GridBagLayout());
        panelTabla.setBackground(Color.white);
        panelTabla.add(new JScrollPane(table));
        cp.add(panelTabla,new GridBagConstraints(0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(300,20,20,20),20,20));
    }
    public JTable setTable(Planta inicio, Planta fin){
        JTable table = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizPlantasFlujoMax(inicio,fin), new String[]{"CAMINO","Kg"}));
        return table;
    }
}
