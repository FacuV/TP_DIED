package Interface.planta;

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
        }
}
