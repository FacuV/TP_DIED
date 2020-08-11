package Interface.ordenesPedido;

import Servicio.Gestor_Camiones;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

public class PantallaCrearOrden extends JFrame{
    public PantallaCrearOrden(){
        super("Crear Orden");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
        JPanel info = new JPanel(new GridLayout(7,2));
        JLabel patente = new JLabel("PATENTE");
        info.add(patente);
        JTextField patenteTextField = new JTextField(50);
        info.add(patenteTextField);
        JLabel marca = new JLabel("MARCA");
        info.add(marca);
        JTextField marcaTextField = new JTextField(50);
        info.add(marcaTextField);
        JLabel modelo = new JLabel("MODELO");
        info.add(modelo);
        JTextField modeloTextField = new JTextField(50);
        info.add(modeloTextField);
        JLabel kilometraje = new JLabel("KILOMETRAJE");
        info.add(kilometraje);
        JTextField kilometrajeTextField = new JTextField(50);
        info.add(kilometrajeTextField);
        JLabel costoXkm = new JLabel("COSTO POR KM");
        info.add(costoXkm);
        JTextField costoXkmTextField = new JTextField(50);
        info.add(costoXkmTextField);
        JLabel costoXhora = new JLabel("COSTO POR HORA");
        info.add(costoXhora);
        JTextField costoXhoraTextField = new JTextField(50);
        info.add(costoXhoraTextField );
        JLabel fechaCompra = new JLabel("FECHA DE COMPRA");
        info.add(fechaCompra);
        JPanel panelFecha = new JPanel(new FlowLayout());
        JLabel barra1 = new JLabel("/"),barra2 = new JLabel("/");
        JTextField dia = new JTextField(2);
        panelFecha.add(dia);
        panelFecha.add(barra1);
        JTextField mes = new JTextField(2);
        panelFecha.add(mes);
        panelFecha.add(barra2);
        JTextField año = new JTextField(4);
        panelFecha.add(año);
        info.add(panelFecha);
        cp.add(info,BorderLayout.CENTER);
        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gestor_Camiones.registrarCamion(patenteTextField.getText(),marcaTextField.getText(),modeloTextField.getText(),Double.parseDouble(kilometrajeTextField.getText()),Double.parseDouble(costoXkmTextField.getText()),Double.parseDouble(costoXhoraTextField.getText()), LocalDate.of(Integer.parseInt(año.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText())));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        cp.add(aceptar,BorderLayout.SOUTH);
    }
}
