package Servicio;

import Negocio.Planta;
import Negocio.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class Gestor_Plantas {
        private static ArrayList<Planta> plantas = new ArrayList<>();
        private static ArrayList<Planta> rutas = new ArrayList<>();

        public static ArrayList<Planta> getPlantas() {return plantas;}
        public static void setPlantas(ArrayList<Planta> plantas){Gestor_Plantas.plantas = plantas;}

        public static ArrayList<Planta> getRutas() {
          return rutas;
        }
        public static void setRutas(ArrayList<Planta> rutas) {
             Gestor_Plantas.rutas = rutas;
        }

    public static void registrarPlanta(String nombre){
            if(plantas.isEmpty()){
                plantas.add(new Planta(nombre,1));
            }else{
                plantas.add(new Planta(nombre, plantas.get(plantas.size()-1).getId()+1));
            }
        }
    public static List<Planta> plantasBajoPuntoReposicion(){
            ArrayList rtn = new ArrayList();
            boolean aux = false;
            for(Planta planta: plantas){
                for(Stock stock: planta.getInsumos()){
                    if(stock.getCantidad() < stock.getPunto_reposicion()){aux = true;}
                }
                if(aux){
                    rtn.add(planta);
                    aux = false;
                }
            }
            return rtn;
    }


}
