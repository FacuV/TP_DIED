package Interface.planta;

import Negocio.Planta;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PantallaFlujoMaximo extends JFrame {
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
                JPanel centrar = new JPanel();
                centrar.setLayout(new GridBagLayout());
                JLabel titulo = new JLabel("FLUJO MAXIMO ENTRE");
                centrar.add(titulo,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20));
            aux1.add(centrar);
                JPanel panelComboBox = new JPanel();
                panelComboBox.setLayout(new FlowLayout());
               // JComboBox<Planta> comboBox1 = new JComboBox<>(Gestor_Plantas.getPlantas());
                JComboBox<Planta> comboBox2 = new JComboBox<>((ComboBoxModel<Planta>) Gestor_Plantas.getPlantas());
                //panelComboBox.add(comboBox1);panelComboBox.add(new JLabel(" Y "));panelComboBox.add(comboBox2);
            aux1.add(panelComboBox);
        cp.add(aux1,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.NORTH,GridBagConstraints.VERTICAL,new Insets(20,20,20,0),20,20));
            JPanel panelTabla = new JPanel();
        cp.add(panelTabla,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,0),20,20));

    }
}
