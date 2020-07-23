package TP;

import Negocio.Camion;
import Negocio.Planta;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {



    /*
        //Para el testing luego, prueba de la priorityqueue
        Planta planta = new Planta("Planta de facu",0001);

        planta.getCamiones().add(new Camion("1111","modelo5",2000,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("1112","modelo5",2000,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0001","modelo1",0,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0002","modelo1",0,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0111","modelo4",1000,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0112","modelo4",1000,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0011","modelo2",10,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0012","modelo2",10,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0021","modelo3",100,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0022","modelo3",100,10,10, LocalDate.now()));





        System.out.println("---------------------------------------------");
        while (!planta.getCamiones().isEmpty()){
            System.out.println(planta.getCamiones().poll().getPatente());
        }

     */











        /*
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
        frame.setVisible(true);*/
        
    }
}
