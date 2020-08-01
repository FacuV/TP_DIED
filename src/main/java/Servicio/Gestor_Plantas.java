package Servicio;

import Daos.PlantaDaoDB;
import Daos.RutaDaoDB;
import Negocio.*;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Gestor_Plantas {
    //Esta es una lista de todas las plantas que tienen la empresa
    private static ArrayList<Planta> plantas = new ArrayList<>();
    //Esta es una lista de todas las rutas que tiene la empresa
    private static ArrayList<Ruta> rutas = new ArrayList<>();

    //Este método devuelve la lista de todas las plantas de la empresa
    public static ArrayList<Planta> getPlantas() {
        return plantas;
    }

    //Este método te permite modificar toda la lista de plantas por una nueva
    public static void setPlantas(ArrayList<Planta> plantas) {
        Gestor_Plantas.plantas = plantas;
    }

    //Este método devuelve la lista de todas las rutas de la empresa
    public static ArrayList<Ruta> getRutas() {
        return rutas;
    }

    //Este método te permite modificar todas las rutas de la empresa por una nueva lista de rutas
    public static void setRutas(ArrayList<Ruta> rutas) {
        Gestor_Plantas.rutas = rutas;
    }

    //Este método te permite registrar una nueva ruta en la empresa tanto en la lista de rutas como en la base de datos
    public static void conectar(Planta nodo1, Planta nodo2, double distancia, int duracion_viaje, double cant_max_material) throws SQLException {
        Ruta ruta = new Ruta(nodo1, nodo2, distancia, duracion_viaje, cant_max_material);
        rutas.add(ruta);
        RutaDaoDB rutaDaoDB = new RutaDaoDB();
        rutaDaoDB.createRuta(ruta);
    }

    //Este método permite registrar una nueva planta tanto en la lista de plantas de la empresa como en la base de datos
    public static void registrarPlanta(String nombre) throws SQLException {
        Planta planta;
        if (plantas.isEmpty()) {
            planta = new Planta(nombre, 1);
        } else {
            planta = new Planta(nombre, plantas.get(plantas.size() - 1).getId() + 1);
        }
        plantas.add(planta);
        PlantaDaoDB plantaDaoDB = new PlantaDaoDB();
        plantaDaoDB.createPlanta(planta);
    }

    //Este método te permite obtener una planta de la lista de plantas de la empresa pasando como parámetro su id
    public static Planta getPlanta(int id_planta) {
        return plantas.get(id_planta - 1);
    }

    //Este método devuelve una lista con las plantas que tienen algún insumo en cantidades inferiores al punto de roposición
    public static List<Planta> plantasBajoPuntoReposicion() {
        ArrayList rtn = new ArrayList();
        boolean aux = false;
        for (Planta planta : plantas) {
            for (Lista_insumos stock : planta.getInsumos()) {
                if (stock.getCantidad() <= stock.getPunto_reposicion()) {
                    aux = true;
                }
            }
            if (aux) {
                rtn.add(planta);
                aux = false;
            }
        }
        return rtn;
    }

    //Este método devuelve una lista que contiene todas las rutas posibles desde una planta origen hasta una planta destino
    public static List<List> rutaPosibles(Planta origen, Planta destino) {
        List aux1 = new ArrayList();
        List aux2 = new ArrayList();
        aux2.add(aux1);
        //Si llegue al destino
        if (origen.equals(destino)) {
            aux1.add(destino);
            return aux2;
        }
        //obtengo adyacentes
        List<Planta> ady = getAdyacentes(origen);
        //Si llegue a una rama muerta
        if (ady.isEmpty()) {
            return aux2;
        }

        List<List> caminosAdy = new ArrayList();
        //Recibo las listas de caminos posibles segun mis nodos adyasentes
        //Creo que tiene un problema, empaqueta el resultado en una lista de forma indeseada, mas abajo hago dos for para desempaquetar
        for (Planta p : ady) {
            caminosAdy.add((List) Stream.concat(aux1.stream(), rutaPosibles(p, destino).stream()).collect(Collectors.toList()));
        }
        //por si estoy en una rama muerta
        if (caminosAdy.size() == 1 && caminosAdy.get(0).isEmpty()) {
            return aux2;
        }
        //Genero la lista con el origen del camino
        List resultado = new ArrayList();
        List listaA = new ArrayList();
        listaA.add(origen);
        //Agrego al inicio de todos los caminos el origen
        for (List<List> list : caminosAdy) {
            //solucionando el problema de desempaquetar los caminos
            for (List listaux : list) {
                //Si el camino no era camino muerto me agrego como inicio, de lo contrario lo ignoro
                if (!list.get(0).isEmpty()) {
                    resultado.add(Stream.concat(listaA.stream(), listaux.stream()).collect(Collectors.toList()));
                }
            }
        }
        return resultado;
    }

    //Este método devuelve las plantas que tienen stock para la orden de pedido y que tienen un camino posible con la planta que emitio la orden de pedido
    public static List<Planta> plantasConStock(Orden_Pedido orden) {
        ArrayList<Planta> todasLasPlantas = new ArrayList();
        boolean tiene_insumos = true;
        for (Planta p : plantas) {
            if (!p.equals(orden.getPlanta_destino())) {
                for (Lista_insumos l : orden.getInsumos_pedidos()) {
                    if (p.getInsumos().contains(l)) {
                        if (p.getInsumos().get(p.getInsumos().indexOf(l)).getCantidad() < l.getCantidad()) {
                            tiene_insumos = false;
                        }
                    } else {
                        tiene_insumos = false;
                    }
                }
                if (tiene_insumos) {
                    todasLasPlantas.add(p);
                } else {
                    tiene_insumos = true;
                }
            }
        }
        ArrayList rtn = new ArrayList();
        for (Planta planta : todasLasPlantas) {
            if (!rutaPosibles(planta, orden.getPlanta_destino()).get(0).isEmpty()) {
                rtn.add(planta);
            }
        }
        return rtn;
    }

    //Este método permite actualizar el stock de una planta
    public static void actualizarStock(int id_planta, Insumo I, double cantidad, double punto_pedido) {
        for (Lista_insumos l : Gestor_Plantas.getPlanta(id_planta).getInsumos()) {
            if (l.getInsumo().equals(I)) {
                l.setCantidad(cantidad);
                l.setPunto_reposicion(punto_pedido);
            }
        }
    }

    //Este método retorna una lista de plantas adyacentes a la planta que se pasa como parámetro
    public static List<Planta> getAdyacentes(Planta unNodo) {
        List<Planta> salida = new ArrayList<Planta>();
        for (Ruta enlace : rutas) {
            if (enlace.getPlanta_origen().equals(unNodo)) {
                salida.add(enlace.getPlanta_destino());
            }
        }
        return salida;
    }


    //Este método retorna la cantidad de caminos que llega a una planta que se pasa como parámetro
    public static Integer gradoEntrada(Planta vertice) {
        Integer res = 0;
        for (Ruta arista : rutas) {
            if (arista.getPlanta_destino().equals(vertice)) ++res;
        }
        return res;
    }


    //Este método retorna la cantidad de caminos que salen de la planta pasada como parámetro
    public static Integer gradoSalida(Planta vertice) {
        Integer res = 0;
        for (Ruta arista : rutas) {
            if (arista.getPlanta_origen().equals(vertice)) ++res;
        }
        return res;
    }

    //Si el camino es a sí misma o no hay camino el lugar aparece vacío
    //Este método devuelve una matriz donde se indica el camínimo mínimo que va desde la planata de la fila hacia la planta de la columna
    public static List<Planta>[][] matrizCaminoMinimo(boolean parametro){
        // si el parámetro es true se calcula por tiempo, si es false se calcula por km recorridos

        //esta es la matriz que retornaré
        List<Planta>[][] rta = new List[plantas.size()][plantas.size()];
        // aquí guardaré las rutas posibles de una planta a otra para luego compararlas
        List<List> caminos;

        // creo 2 bucles for para recorrer toda la matriz
        for(int i=0; i<plantas.size(); i++){
            for(int j=0; j<plantas.size(); j++){
                //en caso de que sea hacia sí mismo solo imprimo en blanco
                if(i==j){
                    rta[i][j] = new ArrayList<>();
                }else {
                    //guardo las rutas posibles desde la planta j a la planta i (fila a columna)
                    caminos = rutaPosibles(plantas.get(i), plantas.get(j));
                    //si la cantidad de rutas que encuentra es 1, puede ser la única ruta o que la ruta no exista. En cualquier caso va como valor a la matriz
                    if (rutas.size() == 1) {
                        rta[i][j] = caminos.get(0);
                    } else {//en caso de que sean más tengo que encontrar la ruta con menor km o tiempo según parametro
                        rta[i][j] = masCorta(caminos, parametro);
                    }
                }
            }
        }

        return rta;
    }

    //Este método retorna una lista de plantas por donde es el camino más corto de todas las listas de caminos que se envió, por tiempo si el parámetro es true y por distancia si el parámetro es false
    private static List<Planta> masCorta (List<List> caminos , boolean parametro){
        // este parámetro me permite recordar cual indice enviar
        List respuesta = new ArrayList();
        double cant_min = 0;
        double sum;
        Ruta coneccion;

        for(List lista:caminos) {
            sum = 0;
            for (int j = 0; j < lista.size() - 1; j++) {
                coneccion = getCamino((Planta) lista.get(j), (Planta) lista.get(j+1));
                //si el parámetro es true se calcula la que tenga menor tiempo
                if(parametro == true){
                    sum += coneccion.getDuracion_viaje();
                } else{
                    sum += coneccion.getDistancia();
                }
            }
            //si es la primera pasada o si la suma de los caminos ahora es menos que la anterior, se reemplazan las variables
            if(cant_min == 0 || cant_min > sum) {
                cant_min = sum;
                respuesta = lista;
            }
        }
        return respuesta;
    }

    //Este método retorna la ruta que va desde la planta de inicio hasta la del fin y null si es que no existe
    public static Ruta getCamino(Planta inicio, Planta fin){
        for(Ruta ruta:rutas){
            if(ruta.getPlanta_origen().equals(inicio) && ruta.getPlanta_destino().equals(fin)){
                return ruta;
            }
        }
        //un return para que no me marque error
        return null;
    }

    //METODO NO TERMINADO
    //debe retornar una lista ordenada de plantas según algoritmo de page rack
    public static ArrayList<Planta> plantasPageRank(){
        return null;
    }

    //METODO NO TERMINADO
    //debe retornar el subgrafo de mayor flujo entre la planta de origen y la de destino
    public static ArrayList<Planta> flujoMax(Planta origen,Planta destino){
        return null;
    }

    //METODO NO TERMINADO
    //debe retornar el flujo de una ruta
    public static Integer flujo(ArrayList<Planta> camino){
        return null;
    }
}

