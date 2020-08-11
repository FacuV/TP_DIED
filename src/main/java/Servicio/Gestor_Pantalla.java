package Servicio;

import Interface.camion.Pantalla_Camion;
import Interface.insumo.Pantalla_Insumo;
import Interface.ordenesPedido.Pantalla_Ordenes;
import Interface.planta.Pantalla_Plantas;
import Interface.Pantalla_Principal;
import Interface.ruta.Pantalla_Rutas;
import Negocio.*;

import javax.swing.*;
import java.util.*;

public class Gestor_Pantalla {
    //pantalla principal
    private static final JFrame pantalla_principal = new Pantalla_Principal();
    //pantallas secundarias accedidas mediante botones de la pantalla principal
    private static final JFrame pantalla_plantas = new Pantalla_Plantas();
    private static final JFrame pantalla_camiones = new Pantalla_Camion();
    private static final JFrame pantalla_rutas = new Pantalla_Rutas();
    private static final JFrame pantalla_insumos = new Pantalla_Insumo();
    private static final JFrame pantalla_ordenes = new Pantalla_Ordenes();

    public static final int PRINCIPAL = 0;
    public static final int PLANTAS = 1;
    public static final int CAMIONES = 2;
    public static final int RUTAS = 3;
    public static final int INSUMOS = 4;
    public static final int ORDENES = 5;

    private static JFrame[] pantallas_secundarias = {pantalla_principal,pantalla_plantas,pantalla_camiones,pantalla_rutas,pantalla_insumos,pantalla_ordenes};
    private static boolean[] info_pantallas = {false,false,false,false,false,false};
    public static void setOffAll(){
        for(int i=0;i<pantallas_secundarias.length;i++){
            if(info_pantallas[i]){
                info_pantallas[i] = false;
                pantallas_secundarias[i].setVisible(false);
            }
        }
    }
    public static void visualizarPantalla_principal(){
        info_pantallas[PRINCIPAL] = true;
        pantalla_principal.setVisible(true);
    }
    public static void noVisualizarPantalla_principal(){
        info_pantallas[PRINCIPAL] = false;
        pantalla_principal.setVisible(false);
    }

    public static void visualizarPantalla_plantas(){
        info_pantallas[PLANTAS] = true;
        pantalla_plantas.setVisible(true);
    }
    public static void noVisualizarPantalla_plantas(){
        info_pantallas[PLANTAS] = false;
        pantalla_plantas.setVisible(false);
    }

    public static void visualizarPantalla_camiones(){info_pantallas[CAMIONES] = true;pantalla_camiones.setVisible(true);}
    public static void noVisualizarPantalla_camiones(){info_pantallas[CAMIONES] = false;pantalla_camiones.setVisible(false);}

    public static void visualizarPantalla_rutas(){info_pantallas[RUTAS] = true;pantalla_rutas.setVisible(true);}
    public static void noVisualizarPantalla_rutas(){info_pantallas[RUTAS] = false;pantalla_rutas.setVisible(false);}

    public static void visualizarPantalla_insumos(){info_pantallas[INSUMOS] = true;;pantalla_insumos.setVisible(true);}
    public static void noVisualizarPantalla_insumos(){info_pantallas[INSUMOS] = false;pantalla_insumos.setVisible(false);}

    public static void visualizarPantalla_ordenes(){info_pantallas[ORDENES] = true;pantalla_ordenes.setVisible(true);}
    public static void noVisualizarPantalla_ordenes(){info_pantallas[ORDENES] = false;pantalla_ordenes.setVisible(false);}
    public static String[][] obtenerMatrizDatosDetalleInsumos(Orden_Pedido ordenPedido){
        ArrayList<Lista_insumos> detalleInsumos = ordenPedido.getInsumos_pedidos();
        String[] titulos = new String[]{"INSUMO","CANTIDAD","PRECIO"};
        String informacion[][] = new String[detalleInsumos.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = detalleInsumos.get(x).getInsumo() + "";
            informacion[x][1] = detalleInsumos.get(x).getCantidad() + "";
            informacion[x][2] = ((Detalle_Insumos)detalleInsumos.get(x)).getPrecio()+"";
        }
        return informacion;
    }
    public static String[][] obtenerMatrizDatosOrdenes(String estado){
        ArrayList<Orden_Pedido> ordenes = (ArrayList<Orden_Pedido>) (Gestor_Ordenes_Pedido.getOrdenes()).clone();
        String[] titulos = new String[]{"NUMERO","PLANTA DESTINO","ESTADO","FECHA SOLICITUD","FECHA MAX ENTREGA","COSTO VIAJE"};
        if(estado != null){
            ordenes.removeIf(e -> !(e.getEstado().toString().contentEquals(estado)));
        }
        String informacion[][] = new String[ordenes.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = ordenes.get(x).getNumero() + "";
            informacion[x][1] = ordenes.get(x).getPlanta_destino() + "";
            informacion[x][2] = ordenes.get(x).getEstado() + "";
            informacion[x][3] = ordenes.get(x).getFecha_solicitud() + "";
            informacion[x][4] = ordenes.get(x).getFecha_maxima_entrega() + "";
            informacion[x][5] = (ordenes.get(x).getEstado().equals(Estado.PROCESADA) || ordenes.get(x).getEstado().equals(Estado.ENTREGADA))? String.valueOf(ordenes.get(x).getDetalle_envio().getCosto_envio()) :0.0 + "";
        }
        return informacion;
    }
    public static String[][] obtenerMatrizDatosCamiones(String patente,String modelo,String kmRec,String costoXkm,String costoXhora,String fechaCompra){
        ArrayList<Camion> camiones = new ArrayList(Arrays.asList(Gestor_Camiones.getCamiones().toArray(new Camion[0])));
        String[] titulos = new String[]{"PATENTE","MARCA", "MODELO", "KM RECORRIDOS", "COSTO POR KM","COSTO POR HORA","FECHA DE COMPRA"};
        if(patente != null){camiones.removeIf(l -> !l.getPatente().equals(patente));}
        if(modelo != null){camiones.removeIf(l -> !l.getModelo().equals(modelo));}
        if(kmRec != null){camiones.removeIf(l -> !(l.getKm_recorridos() == Double.parseDouble(kmRec)));}
        if(costoXkm != null){camiones.removeIf(l -> !(l.getCosto_km()==Double.parseDouble(costoXkm)));}
        if(costoXhora != null){camiones.removeIf(l -> !(l.getCosto_hora()==Double.parseDouble(costoXhora)));}
        if(fechaCompra != null){camiones.removeIf(l -> !(l.getFecha_compra().equals(fechaCompra)));}
        String informacion[][] = new String[camiones.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++){
            informacion[x][0] = camiones.get(x).getPatente() + "";
            informacion[x][1] = camiones.get(x).getMarca() + "";
            informacion[x][2] = camiones.get(x).getModelo() + "";
            informacion[x][3] = camiones.get(x).getKm_recorridos() + "";
            informacion[x][4] = camiones.get(x).getCosto_km() + "";
            informacion[x][5] = camiones.get(x).getCosto_hora() + "";
            informacion[x][6] = camiones.get(x).getFecha_compra() + "";
        }
        return informacion;
    }
    public static String[][] obtenerMatrizDatosRutas(){
        List<Ruta> rutas = Gestor_Plantas.getRutas();
        String[] titulos = new String[]{"PLANTA ORIGEN","PLANTA DESTINO", "DISTANCIA", "DURACION", "PESO MAX"};
        String informacion[][] = new String[rutas.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = rutas.get(x).getPlanta_origen() + "";
            informacion[x][1] = rutas.get(x).getPlanta_destino() + "";
            informacion[x][2] = rutas.get(x).getDistancia() + "";
            informacion[x][3] = rutas.get(x).getDuracion_viaje() + "";
            informacion[x][4] = rutas.get(x).getCant_max_material() + "";
        }
        return informacion;
    }
    public static String[][] obtenerMatrizDatosInsumos(){
        List<Insumo> insumos = Gestor_Insumos.getInsumos();
        String[] titulos = new String[]{"ID","DESCRPCION", "UNIDAD DE MEDIDA", "COSTO", "PESO/DENSIDAD", "STOCK TOTAL"};
        String informacion[][] = new String[insumos.size()][titulos.length];

        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = insumos.get(x).getId_insumo()+ "";
            informacion[x][1] = insumos.get(x).getDescripcion()+ "";
            informacion[x][2] = insumos.get(x).getUnidad_medida()+ "";
            informacion[x][3] = insumos.get(x).getCosto()+ "";
            informacion[x][4] = (insumos.get(x) instanceof Insumo_General)? String.valueOf(((Insumo_General)insumos.get(x)).getPeso_kilos()) :((Insumo_Liquido)insumos.get(x)).getDensidad()+ "";
            informacion[x][5] = Gestor_Insumos.cantidadTotal(insumos.get(x))+ "";
        }
        return informacion;
    }
    public static String[][] getMatrizBajoPuntoReposicion(Planta filtroPlanta,Insumo filtroInsumo) {
        String[] titulos = new String[]{"PLANTA", "INSUMO", "STOCK EN PLANTA", "PUNTO DE PEDIDO", "STOCK TOTAL"};
        List<List> todasLasPlantasInsumo = Gestor_Plantas.plantasInsumoBajoPuntoReposicion();
            if(filtroPlanta != null){
                todasLasPlantasInsumo.removeIf(l -> !l.get(0).equals(filtroPlanta));
            }
            if(filtroInsumo != null){
                todasLasPlantasInsumo.removeIf(l -> !l.get(1).equals(filtroInsumo));
            }
        String informacion[][] = new String[todasLasPlantasInsumo.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = todasLasPlantasInsumo.get(x).get(0).toString()+ "";
            informacion[x][1] = todasLasPlantasInsumo.get(x).get(1).toString()+ "";
            informacion[x][2] = todasLasPlantasInsumo.get(x).get(2).toString()+ "";
            informacion[x][3] = todasLasPlantasInsumo.get(x).get(3).toString() + "";
            informacion[x][4] = Gestor_Insumos.cantidadTotal((Insumo) todasLasPlantasInsumo.get(x).get(1)) + "";
        }
        return informacion;
    }


    public static String[][] getMatrizPlantasFlujoMax(Planta inicio,Planta fin){
        String[] titulos = new String[]{"CAMINO","KG"};
        ArrayList todasLasPlantas = Gestor_Plantas.flujoMaxPlantas(inicio,fin);
        ArrayList flujos = Gestor_Plantas.flujoMaxSubPesos(inicio, fin);
        String informacion[][] = new String[todasLasPlantas.size()][titulos.length];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = todasLasPlantas.get(x).toString() + "";
            informacion[x][1] = flujos.get(x).toString()+ "";
        }
        return informacion;
    }
    public static String[][] getMatrizPlantasCaminosMinimo(){
        String[] titulos = new String[]{"PLANTA ORIGEN","PLANTA DESTINO","CAMINO MAS CORTO","CAMINO MAS RAPIDO"};
        List[][] porTiempo = Gestor_Plantas.matrizCaminoMinimo(true);
                ArrayList<List> porTiempoPlano = new ArrayList();
                for (int x = 0; x < porTiempo.length; x++) {
                    for(int i = 0; i < porTiempo.length; i++){
                        if(!porTiempo[x][i].isEmpty()){
                            porTiempoPlano.add(porTiempo[x][i]);
                        }
                    }
                }
        List[][] porDistancia = Gestor_Plantas.matrizCaminoMinimo(false);
            ArrayList<List> porDistanciaPlano = new ArrayList();
        for (int x = 0; x < porDistancia.length; x++) {
            for(int i = 0; i < porDistancia.length; i++){
                if(!porDistancia[x][i].isEmpty()){
                    porDistanciaPlano.add(porDistancia[x][i]);
                }
            }
        }
        String informacion[][] = new String[porTiempoPlano.size()][titulos.length];
        for (int x = 0; x < porTiempoPlano.size(); x++) {
            informacion[x][0] = porTiempoPlano.get(x).get(0)+"";
            informacion[x][1] = porTiempoPlano.get(x).get(porTiempoPlano.get(x).size()-1)+"";
            informacion[x][2] = porTiempoPlano.get(x)+"";
            informacion[x][3] = porDistanciaPlano.get(x)+"";

        }
        return informacion;
    }
    public static String[][] getMatrizPlantas(String nombre){
        String[] titulos = new String[]{"ID Planta","Nombre"};
        ArrayList<Planta> todasLasPlantas = Gestor_Plantas.getPlantas();
        ArrayList<Planta> plantasSeleccionadas = new ArrayList<>();
        if(nombre == null || nombre.isBlank()){
            plantasSeleccionadas = todasLasPlantas;
        }else{
            for (Planta planta: todasLasPlantas){
                if(planta.getNombre().contains(nombre)) plantasSeleccionadas.add(planta);
            }
        }
        return obtenerMatrizDatos(plantasSeleccionadas,titulos);
    }
    public static String[][] obtenerMatrizDatos(ArrayList<Planta> plantas,String[] titulos) {

        String informacion[][] = new String[plantas.size()][titulos.length];

        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = plantas.get(x).getId() + "";
            informacion[x][1] = plantas.get(x).getNombre()+ "";
        }
        return informacion;
    }


}

