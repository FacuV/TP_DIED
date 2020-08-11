package Interface.ordenesPedido;

import Interface.ModeloTabla;
import Negocio.Orden_Pedido;
import Servicio.Gestor_Pantalla;

import javax.swing.*;
import java.awt.*;

public class PantallaVerDetalle extends JFrame {
    public PantallaVerDetalle(Orden_Pedido ordenPedido){
        super("Crear Orden");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp.setBackground(Color.white);
        cp.setLayout(new BorderLayout());
            JTable tabla = new JTable(new ModeloTabla(Gestor_Pantalla.obtenerMatrizDatosDetalleInsumos(ordenPedido),new String[]{"INSUMO","CANTIDAD","PRECIO"}));
        cp.add(new JScrollPane(tabla),BorderLayout.CENTER);
    }
}
