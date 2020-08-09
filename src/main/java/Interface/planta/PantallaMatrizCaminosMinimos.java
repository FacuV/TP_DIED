package Interface.planta;

import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.*;

public class PantallaMatrizCaminosMinimos extends JFrame{
    public PantallaMatrizCaminosMinimos(){
            super("Matriz De Caminos Minimos");
            setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocationRelativeTo(null);
            Container cp = getContentPane();
            cp.setBackground(Color.white);
            cp.setLayout(new BorderLayout());
                //JTable table = new JTable(new ModeloTabla(Gestor_Pantalla.getMatrizPlantasCaminosMinimo(),new String[]{"PLANTA ORIGEN","PLANTA DESTINO","CAMINO MAS CORTO","CAMINO MAS RAPIDO"}));
                JScrollPane scrollPane = new JScrollPane();

    }
}
