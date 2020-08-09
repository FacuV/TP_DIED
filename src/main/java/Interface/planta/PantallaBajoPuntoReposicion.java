package Interface.planta;

import Negocio.Planta;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
            JPanel panelComboBox = new JPanel();
            panelComboBox.setLayout(new GridBagLayout());
                JComboBox plantas = new JComboBox();
                JComboBox insumos = new JComboBox();

                /*for (List list: Gestor_Plantas.plantasBajoPuntoReposicion()){
                        for(Object object: list){
                            if(object instanceof Planta) plantas.addItem(object);
                            else if(object instanceof ArrayList) insumos.addItem(((ArrayList) object).get(0));
                        }
                    }

                 */
                plantas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                insumos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        cp.add(panelComboBox,new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.WEST,GridBagConstraints.VERTICAL,new Insets(20,0,0,0),20,20))
    }
}
