package Interface.planta;

import Interface.ModeloTabla;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;

public class PantallaPageRank extends JFrame {
        public PantallaPageRank(){
            super("Page Rank");
            setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocationRelativeTo(null);
            Container cp = getContentPane();
            cp.setBackground(Color.white);
            cp.setLayout(new BorderLayout());
                JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatos(Gestor_Plantas.plantasPageRank(),new String[]{"ID PLANTA","NOMBRE"}),new String[]{"ID PLANTA","NOMBRE"}));
                JScrollPane scrollPane = new JScrollPane(tabla);
            cp.add(scrollPane,BorderLayout.CENTER);
        }
}
