package Interface.camion;

import Negocio.Camion;
import Negocio.Insumo_General;
import Negocio.Insumo_Liquido;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Insumos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

public class PantallaEditarCamion extends JFrame{
    public PantallaEditarCamion(Camion camion){
        super("Editar Camion");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
        JPanel info = new JPanel(new GridLayout(6,2));
        JLabel marca = new JLabel("MARCA");
        info.add(marca);
        JTextField marcaTextField = new JTextField(camion.getMarca(),50);
        info.add(marcaTextField);
        JLabel modelo = new JLabel("MODELO");
        info.add(modelo);
        JTextField modeloTextField = new JTextField(camion.getModelo(),50);
        info.add(modeloTextField);
        JLabel kilometraje = new JLabel("KILOMETRAJE");
        info.add(kilometraje);
        JTextField kilometrajeTextField = new JTextField(String.valueOf(camion.getKm_recorridos()),50);
        info.add(kilometrajeTextField);
        JLabel costoXkm = new JLabel("COSTO POR KM");
        info.add(costoXkm);
        JTextField costoXkmTextField = new JTextField(String.valueOf(camion.getCosto_km()),50);
        info.add(costoXkmTextField);
        JLabel costoXhora = new JLabel("COSTO POR HORA");
        info.add(costoXhora);
        JTextField costoXhoraTextField = new JTextField(String.valueOf(camion.getCosto_hora()),50);
        info.add(costoXhoraTextField );
        JLabel fechaCompra = new JLabel("FECHA DE COMPRA");
        info.add(fechaCompra);
        JPanel panelFecha = new JPanel(new FlowLayout());
            LocalDate fechaDeCompra = camion.getFecha_compra();
            JLabel barra1 = new JLabel("/"),barra2 = new JLabel("/");
            JTextField dia = new JTextField(String.valueOf(fechaDeCompra.getDayOfMonth()),2);
            panelFecha.add(dia);
            panelFecha.add(barra1);
            JTextField mes = new JTextField(String.valueOf(fechaDeCompra.getMonthValue()),2);
            panelFecha.add(mes);
            panelFecha.add(barra2);
            JTextField año = new JTextField(String.valueOf(fechaDeCompra.getYear()),4);
            panelFecha.add(año);
        info.add(panelFecha);
        cp.add(info,BorderLayout.CENTER);
        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gestor_Camiones.modificacion(camion.getPatente(),marcaTextField.getText(),modeloTextField.getText(),Double.parseDouble(kilometrajeTextField.getText()),Double.parseDouble(costoXkmTextField.getText()),Double.parseDouble(costoXhoraTextField.getText()),LocalDate.of(Integer.parseInt(año.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText())));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        cp.add(aceptar,BorderLayout.SOUTH);
    }
}
