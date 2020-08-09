package Servicio;

import Daos.InsumoDao;
import Daos.InsumoDaoDB;
import Negocio.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Gestor_Insumos{
    //Esta es una lista de todos los insumos con los que cuenta la empresa
    private static ArrayList<Insumo> insumos = new ArrayList<>();

    //Este método registra un insumo general y lo agrega tanto a la lista de insumos de la empresa como a la base de datos
    public static void registrarInsumoG(String descripcion, String unidad_medida, double costo, double peso) throws SQLException {
        int id;
        if(insumos.isEmpty()){
            id = 1;
        }else{
            id = insumos.get(insumos.size()-1).getId_insumo()+1;
        }
        Insumo_General insumo_general = new Insumo_General(id,descripcion,unidad_medida,costo,peso);
        insumos.add(insumo_general);
        InsumoDaoDB insumoDaoDB = new InsumoDaoDB();
        insumoDaoDB.createInsumo(insumo_general);
    }

    //Este método, después de traer el insumo de la BD, lo ingresa a la lista de insumos disponibles (general)
    public static void traerInsumoGBD(String descripcion, String unidad_medida, double costo, double peso,Integer id){
        Insumo_General insumo_general = new Insumo_General(id,descripcion,unidad_medida,costo,peso);
        insumos.add(id-1,insumo_general);
    }

    //Este método registra un insumo líquido y lo agrega tanto a la lista de insumos de la empresa como a la base de datos
    public static void registrarInsumoL(String descripcion, String unidad_medida, double costo, double densidad) throws SQLException {
        int id;
        if(insumos.isEmpty()){
            id = 1;
        }else{
            id = insumos.get(insumos.size()-1).getId_insumo()+1;
        }
        Insumo_Liquido insumo_liquido = new Insumo_Liquido(id,descripcion,unidad_medida,costo,densidad);
        insumos.add(insumo_liquido);
        InsumoDaoDB insumoDaoDB = new InsumoDaoDB();
        insumoDaoDB.createInsumo(insumo_liquido);
    }

    //Este método, después de traer el insumo de la BD, lo ingresa a la lista de insumos disponibles
    public static void traerInsumoLBD(String descripcion, String unidad_medida, double costo, double densidad, Integer id){
        Insumo_Liquido insumo_liquido = new Insumo_Liquido(id,descripcion,unidad_medida,costo,densidad);
        insumos.add(id-1,insumo_liquido);
    }

    //Este método borra un insumo (general o líquido) de la lista de insumos de la empresa y de la base de datos
    public static void baja(int id_insumo) throws SQLException {
        insumos.remove(insumos.get(id_insumo-1));
        InsumoDaoDB insumoDaoDB = new InsumoDaoDB();
        insumoDaoDB.deleteInsumo(insumos.get(id_insumo-1));
    }

    //Pasar null en los dos primeros si no se los quiere modificar y 0 en los demas que no se quieran modficar
    //Este método modifica el insumo con los datos que se quieran modificar tanto en la lista de insumos de la empresa como en la base de datos
    public static void modificacion(int id_insumo, String descripcion, String unidad_medida, double costo, double peso_densidad) throws SQLException {
        Insumo insumo = insumos.get(id_insumo-1);
        if(descripcion != null){insumo.setDescripcion(descripcion);}
        if(unidad_medida != null){insumo.setUnidad_medida(unidad_medida);}
        if(costo > 0){insumo.setCosto(costo);}
        if(peso_densidad > 0){
            if(insumo instanceof Insumo_General){
                ((Insumo_General) insumos.get(id_insumo-1)).setPeso_kilos(peso_densidad);
            }else{
                ((Insumo_Liquido) insumos.get(id_insumo-1)).setDensidad(peso_densidad);
            }
        }
        InsumoDaoDB insumoDaoDB = new InsumoDaoDB();
        insumoDaoDB.updateInsumo(insumo);
    }

    //Este método retorna la lista de todos los insumos que posee la empresa
    public static List<Insumo> getInsumos(){return insumos;}


    //Este método retorna el insumo que tenga como id el numero que se le pasa
    public static Insumo getInsumo(int id_insumo){return insumos.get(id_insumo-1);}

    //Este método devuelve la cantidad de un insumo que hay en toda la empresa
    public static int cantidadTotal(Insumo insumo){
        int rtn = 0;
        for(Planta planta:Gestor_Plantas.getPlantas()){
            for(Lista_insumos stock: planta.getInsumos()){
                if(stock.getInsumo().equals(insumo)){rtn+= stock.getCantidad();}
            }
        }
        return  rtn;
    }
}
