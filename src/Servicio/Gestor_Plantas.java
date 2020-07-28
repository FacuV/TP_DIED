package Servicio;

import Negocio.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Gestor_Plantas {
    private static ArrayList<Planta> plantas = new ArrayList<>();
    private static ArrayList<Ruta> rutas = new ArrayList<>();

    public static ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public static void setPlantas(ArrayList<Planta> plantas) {
        Gestor_Plantas.plantas = plantas;
    }

    public static ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public static void setRutas(ArrayList<Ruta> rutas) {
        Gestor_Plantas.rutas = rutas;
    }

    public static void conectar(Planta nodo1, Planta nodo2, double distancia, int duracion_viaje, double cant_max_material) {
        rutas.add(new Ruta(nodo1, nodo2, distancia, duracion_viaje, cant_max_material));
    }

    public static void registrarPlanta(String nombre) {
        if (plantas.isEmpty()) {
            plantas.add(new Planta(nombre, 1));
        } else {
            plantas.add(new Planta(nombre, plantas.get(plantas.size() - 1).getId() + 1));
        }
    }
    public static Planta getPlanta(int id_planta){
        return plantas.get(id_planta-1);
    }
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

    public static List<List> rutaPosibles(Planta origen,Planta destino) {
        List aux1 = new ArrayList();
        List aux2 = new ArrayList();
        aux2.add(aux1);
        //Si llegue al destino
        if(origen.equals(destino)){
            aux1.add(destino);
            return aux2;
        }
        //obtengo adyacentes
        List<Planta> ady = getAdyacentes(origen);
        //Si llegue a una rama muerta
        if(ady.isEmpty()){return aux2;}

        List<List> caminosAdy = new ArrayList();
        //Recibo las listas de caminos posibles segun mis nodos adyasentes
        //Creo que tiene un problema, empaqueta el resultado en una lista de forma indeseada, mas abajo hago dos for para desempaquetar
        for (Planta p: ady){
            caminosAdy.add((List) Stream.concat(aux1.stream(),rutaPosibles(p,destino).stream()).collect(Collectors.toList()));
        }
        //por si estoy en una rama muerta
        if(caminosAdy.size()==1 && caminosAdy.get(0).isEmpty()){return aux2;}
        //Genero la lista con el origen del camino
        List resultado = new ArrayList();
        List listaA = new ArrayList();
        listaA.add(origen);
        //Agrego al inicio de todos los caminos el origen
        for (List<List> list:caminosAdy){
            //solucionando el problema de desempaquetar los caminos
            for (List listaux:list) {
                //Si el camino no era camino muerto me agrego como inicio, de lo contrario lo ignoro
                if (!list.get(0).isEmpty()) {
                    resultado.add(Stream.concat(listaA.stream(), listaux.stream()).collect(Collectors.toList()));
                }
            }
        }
        return resultado;
    }
    //Para este metodo solo voy a devolver las plantas que tienen stock y que tienen un camino posible con la planta que emitio la orden de pedido
    public static List<Planta> plantasConStock(Orden_Pedido orden){
        ArrayList<Planta> todasLasPlantas = new ArrayList();
        boolean tiene_insumos=true;
        for(Planta p: plantas){
            if(!p.equals(orden.getPlanta_destino())) {
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
        for(Planta planta:todasLasPlantas){
            if(!rutaPosibles(planta,orden.getPlanta_destino()).get(0).isEmpty()){
                rtn.add(planta);
            }
        }
        return rtn;
    }
    public static void actualizarStock(int id_planta, Insumo I, double cantidad, double punto_pedido){
        for(Lista_insumos l:Gestor_Plantas.getPlanta(id_planta).getInsumos()){
           if(l.getInsumo().equals(I)){
               l.setCantidad(cantidad);
               l.setPunto_reposicion(punto_pedido);
           }
        }
    }
    public static List<Planta> getAdyacentes(Planta unNodo){
        List<Planta> salida = new ArrayList<Planta>();
        for(Ruta enlace : rutas){
            if( enlace.getPlanta_origen().equals(unNodo)){
                salida.add(enlace.getPlanta_destino());
            }
        }
        return salida;
    }
    public Integer gradoEntrada(Planta vertice){
        Integer res =0;
        for(Ruta arista : rutas){
            if(arista.getPlanta_destino().equals(vertice)) ++res;
        }
        return res;
    }

    public Integer gradoSalida(Planta vertice){
        Integer res =0;
        for(Ruta arista : rutas){
            if(arista.getPlanta_origen().equals(vertice)) ++res;
        }
        return res;
    }
    /*
    public List<T> recorridoAnchura(Vertice<T> inicio){
        List<T> resultado = new ArrayList<T>();
        //estructuras auxiliares
        Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
        HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
        marcados.add(inicio);
        pendientes.add(inicio);

        while(!pendientes.isEmpty()){
            Vertice<T> actual = pendientes.poll();
            List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
            resultado.add(actual.getValor());
            for(Vertice<T> v : adyacentes){
                if(!marcados.contains(v)){
                    pendientes.add(v);
                    marcados.add(v);
                }
            }
        }
        //System.out.println(resultado);
        return resultado;
    }

    public List<T> recorridoProfundidad(Vertice<T> inicio){
        List<T> resultado = new ArrayList<T>();
        Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
        HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
        marcados.add(inicio);
        pendientes.push(inicio);

        while(!pendientes.isEmpty()){
            Vertice<T> actual = pendientes.pop();
            List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
            resultado.add(actual.getValor());
            for(Vertice<T> v : adyacentes){
                if(!marcados.contains(v)){
                    pendientes.push(v);
                    marcados.add(v);
                }
            }
        }
        //System.out.println(resultado);
        return resultado;
    }

    public List<T> recorridoTopologico(){
        List<T> resultado = new ArrayList<T>();
        Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
        for(Vertice<T> vert : this.vertices){
            gradosVertice.put(vert, this.gradoEntrada(vert));
        }
        while(!gradosVertice.isEmpty()){

            List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet()
                    .stream()
                    .filter( x -> x.getValue()==0)
                    .map( p -> p.getKey())
                    .collect( Collectors.toList());

            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");

            for(Vertice<T> v : nodosSinEntradas){
                resultado.add(v.getValor());
                gradosVertice.remove(v);
                for(Vertice<T> ady: this.getAdyacentes(v)){
                    gradosVertice.put(ady,gradosVertice.get(ady)-1);
                }
            }
        }

        System.out.println(resultado);
        return resultado;
    }

    private boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
        List<Vertice<T>> ady = this.getAdyacentes(v1);
        for(Vertice<T> unAdy : ady){
            if(unAdy.equals(v2)) return true;
        }
        return false;
    }


    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2) {
        List<Vertice<T>> adyacentes = getAdyacentes(v1);
        for(Vertice<T> vAdy : adyacentes) {
            if(vAdy.equals(v2)) {
                return true;
            } else {
                return hayCamino(vAdy, v2);
            }
        }
        return false;
    }

     */
}
