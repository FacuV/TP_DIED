package Interface;

import Negocio.Planta;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {
    String[] titulos;
    String[][] datos;

    public ModeloTabla(String[][] datos,String[] titulos){
         super();
         this.titulos = titulos;
         this.datos = datos;
         setDataVector(datos,titulos);
    }
    @Override
    public boolean isCellEditable(int row,int column){
        return false;
    }
}
