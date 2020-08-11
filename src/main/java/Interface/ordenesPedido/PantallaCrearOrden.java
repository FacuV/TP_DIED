package Interface.ordenesPedido;

import Negocio.Detalle_Insumos;
import Negocio.Insumo;
import Negocio.Planta;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Insumos;
import Servicio.Gestor_Ordenes_Pedido;
import Servicio.Gestor_Plantas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PantallaCrearOrden extends JFrame{
    public PantallaCrearOrden(){
        super("Crear Orden");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
        JPanel info = new JPanel(new GridLayout(3,2));
        JLabel plantaDestino = new JLabel("PLANTA DESTINO");
        info.add(plantaDestino);
        JComboBox<Planta> plantaDestinoCB = new JComboBox<>();
        info.add(plantaDestinoCB);
            for(Planta planta:Gestor_Plantas.getPlantas()){plantaDestinoCB.addItem(planta);}
        JLabel fechaMaximaDeEntrega = new JLabel("FECHA MAXIMA DE ENTREGA");
        info.add(fechaMaximaDeEntrega);
            JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.CENTER,2,40));
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
        JLabel insumosSolicitados = new JLabel("INSUMOS SOLICITADOS");
        info.add(insumosSolicitados);
            JPanel panelInsumoAux = new JPanel(new GridLayout(2,1));
                JPanel panelInsumo = new JPanel(new GridLayout(2,2));
                JComboBox<Insumo> insumosSolicitadosCB = new JComboBox<>();
                for (Insumo insumo: Gestor_Insumos.getInsumos()){insumosSolicitadosCB.addItem(insumo);}
                panelInsumo.add(insumosSolicitadosCB);
                JLabel cantidad = new JLabel("CANTIDAD");
                panelInsumo.add(cantidad);
                JTextField cantidadTextField = new JTextField(4);
                panelInsumo.add(cantidadTextField);
                JLabel precio = new JLabel("PRECIO ");
                panelInsumo.add(precio);
                JLabel precioImpreso = new JLabel("0");
                panelInsumo.add(precioImpreso);
                    insumosSolicitadosCB.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(!cantidadTextField.getText().isEmpty()) precioImpreso.setText(String.valueOf(((Insumo) insumosSolicitadosCB.getSelectedItem()).getCosto()*Double.parseDouble(cantidadTextField.getText())));
                            revalidate();
                        }
                    });
                    cantidadTextField.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            precioImpreso.setText(String.valueOf(((Insumo) insumosSolicitadosCB.getSelectedItem()).getCosto()*Double.parseDouble(cantidadTextField.getText())));
                            revalidate();
                        }
                    });
            panelInsumoAux.add(panelInsumo);
            JButton agregarInsumo = new JButton("AGREGAR INSUMO");
            ArrayList insumos = new ArrayList();
            agregarInsumo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    precioImpreso.setText("0");
                    insumos.add(new Detalle_Insumos((Insumo) insumosSolicitadosCB.getSelectedItem(),Double.parseDouble(cantidadTextField.getText())));
                    cantidadTextField.setText("");
                    revalidate();
                }
            });
            panelInsumoAux.add(agregarInsumo);
        info.add(panelInsumoAux);
        cp.add(info,BorderLayout.CENTER);
        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gestor_Ordenes_Pedido.registrarOrden((Planta) plantaDestinoCB.getSelectedItem(),LocalDate.of(Integer.parseInt(año.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText())),insumos);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        cp.add(aceptar,BorderLayout.SOUTH);
    }
}
