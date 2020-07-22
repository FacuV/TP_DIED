package TP;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //Pantalla
        JFrame frame = new JFrame("Facu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Panel
        JPanel panelDeContenido = new JPanel();
        //etiqueta
        JLabel etiqueta1 = new JLabel("una etiqueta");
        //Añadir el el panel al frame
            //frame.add(etiqueta1);
        //o con este otro
            frame.setContentPane(etiqueta1);
        //menu
        //JMenu menu = new JMenu("hola");
        //frame.add(menu);
        BorderLayout bl = new BorderLayout(20,20);
        frame.setLayout(bl);

        //cuadro de texto
        JTextField texto = new JTextField("texto",1);
        frame.add(texto);
        JCheckBox cb = new JCheckBox("hola");
        frame.add(cb);
        //Visualizar pantalla
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
        
    }
}
