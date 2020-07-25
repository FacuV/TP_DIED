package Servicio;

import Negocio.Planta;
import Negocio.Ruta;
import Negocio.Stock;

import java.util.*;
import java.util.function.Function;
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

    public static List<Planta> plantasBajoPuntoReposicion() {
        ArrayList rtn = new ArrayList();
        boolean aux = false;
        for (Planta planta : plantas) {
            for (Stock stock : planta.getInsumos()) {
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
    /*
    public static List rutaPosibles(Planta origen,Planta destino) {
        //Primero obtengo
        List<List> aux = rutaPosiblesAux(origen, destino);
        List<List> aux2 = new ArrayList();
        List aux3 = new ArrayList();

        for (List res : aux) {
            aux2.add(aplanador(res));
        }

        for(List<List> list:aux2){
            for (List l:list){
                aux3.add(l);
            }
        }
        return aux3;
    }
    private static List<List> aplanador(List list){
        if(list.size() == 1){
            return list;
        }
        ArrayList inicio = new ArrayList();
        inicio.add(list.get(0));
        list.remove(0);
        ArrayList resultado = new ArrayList();
        ArrayList alvw = new ArrayList();

        for(Object resto: list){
            resultado.add(Stream.concat(inicio.stream(),aplanador((List) resto).stream().flatMap(List::stream)).collect(Collectors.toList()));
        }
        return resultado;
    }
    private static List rutaPosiblesAux(Planta origen,Planta destino) {
        ArrayList<ArrayList> resultado = new ArrayList();
        List<Planta> ady = getAdyacentes(origen);
        if (!origen.equals(destino) && ady.isEmpty()) {
            return null;
        }
        ArrayList a = new ArrayList();
        a.add(destino);
        if (origen.equals(destino)) {
            resultado.add(a);
            return resultado;
        }
        for(Planta planta:ady){
            resultado.add(new ArrayList());
        }
        for(int i =0; i < ady.size();i++){
            resultado.get(i).add(origen);
            resultado.get(i).addAll(rutaPosiblesAux(ady.get(i),destino));

        }
        return resultado;
    }
     */
    public static int cantidadAdy(Planta A,Planta B){
        return  cantidadAdyAux(A, B)+1;
    }
    public static int cantidadAdyAux(Planta A,Planta B){
        int cont =0;
        if(A.equals(B)){return cont;}
        List<Planta> aux = getAdyacentes(A);
        cont = aux.size()-1;
        for (Planta ady: aux){
            cont += (cantidadAdyAux(ady,B));
        }
        return cont;
    }
    /*
    public List<Planta> getAdyacentes(int valor){
        Planta unNodo = this.getNodo(valor);
        List<T> salida = new ArrayList<T>();
        for(Arista<T> enlace : this.aristas){
            if( enlace.getInicio().equals(unNodo)){
                salida.add(enlace.getFin().getValor());
            }
        }
        return salida;
    }

     */

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
