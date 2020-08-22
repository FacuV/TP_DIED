package TP;

import Daos.ConexionRemota;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;
import Negocio.*;
import Servicio.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException{
        getBD();
        Gestor_Pantalla.visualizarPantalla_principal();
        //System.out.println(Gestor_Plantas.getAdyacentes(Gestor_Plantas.getPlanta(1)));
        /*
        ArrayList<Lista_insumos> insumos1 = new ArrayList<>();
        Detalle_Insumos insumo11 = new Detalle_Insumos(Gestor_Insumos.getInsumo(1),20);
        Detalle_Insumos insumo12 = new Detalle_Insumos(Gestor_Insumos.getInsumo(2),30);
        Detalle_Insumos insumo13 = new Detalle_Insumos(Gestor_Insumos.getInsumo(3),10);
        insumos1.add(insumo11);insumos1.add(insumo12);insumos1.add(insumo13);

        ArrayList<Lista_insumos> insumos2 = new ArrayList<>();
        Detalle_Insumos insumo21 = new Detalle_Insumos(Gestor_Insumos.getInsumo(4),20);
        Detalle_Insumos insumo22 = new Detalle_Insumos(Gestor_Insumos.getInsumo(5),30);
        Detalle_Insumos insumo23 = new Detalle_Insumos(Gestor_Insumos.getInsumo(6),10);
        insumos2.add(insumo21);insumos2.add(insumo22);insumos2.add(insumo23);

        ArrayList<Lista_insumos> insumos3 = new ArrayList<>();
        Detalle_Insumos insumo31 = new Detalle_Insumos(Gestor_Insumos.getInsumo(7),20);
        Detalle_Insumos insumo32 = new Detalle_Insumos(Gestor_Insumos.getInsumo(8),30);
        Detalle_Insumos insumo33 = new Detalle_Insumos(Gestor_Insumos.getInsumo(9),10);
        insumos3.add(insumo31);insumos3.add(insumo32);insumos3.add(insumo33);

        ArrayList<Lista_insumos> insumos4 = new ArrayList<>();
        Detalle_Insumos insumo41 = new Detalle_Insumos(Gestor_Insumos.getInsumo(10),20);
        Detalle_Insumos insumo42 = new Detalle_Insumos(Gestor_Insumos.getInsumo(1),30);
        Detalle_Insumos insumo43 = new Detalle_Insumos(Gestor_Insumos.getInsumo(2),10);
        insumos4.add(insumo41);insumos4.add(insumo42);insumos4.add(insumo43);

        ArrayList<Lista_insumos> insumos5 = new ArrayList<>();
        Detalle_Insumos insumo51 = new Detalle_Insumos(Gestor_Insumos.getInsumo(3),20);
        Detalle_Insumos insumo52 = new Detalle_Insumos(Gestor_Insumos.getInsumo(4),30);
        Detalle_Insumos insumo53 = new Detalle_Insumos(Gestor_Insumos.getInsumo(5),10);
        insumos5.add(insumo51);insumos5.add(insumo52);insumos5.add(insumo53);

        ArrayList<Lista_insumos> insumos6 = new ArrayList<>();
        Detalle_Insumos insumo61 = new Detalle_Insumos(Gestor_Insumos.getInsumo(6),20);
        Detalle_Insumos insumo62 = new Detalle_Insumos(Gestor_Insumos.getInsumo(7),30);
        Detalle_Insumos insumo63 = new Detalle_Insumos(Gestor_Insumos.getInsumo(8),10);
        insumos6.add(insumo61);insumos6.add(insumo62);insumos6.add(insumo63);


        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(10),LocalDate.parse("2020-12-12"),insumos1);
        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(10),LocalDate.parse("2020-12-20"),insumos2);

        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(10),LocalDate.parse("2020-12-21"),insumos3);
        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(10),LocalDate.parse("2020-12-22"),insumos4);

        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(1),LocalDate.parse("2020-12-23"),insumos5);
        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(1),LocalDate.parse("2020-12-24"),insumos6);


        Planta planta_origen1= Gestor_Plantas.plantasConStock(Gestor_Ordenes_Pedido.getOrden(1)).get(0);
        Planta planta_destino1=Gestor_Plantas.getPlanta(10);
        List<List> caminos_posibles1 = Gestor_Plantas.rutaPosibles(planta_origen1,planta_destino1);
        ArrayList<Ruta> rutas1 = Gestor_Plantas.plantasARutas((ArrayList)Gestor_Plantas.masCorta(caminos_posibles1,true));

        Gestor_Ordenes_Pedido.pasarAProcesada(Gestor_Ordenes_Pedido.getOrden(1),rutas1);

        Planta planta_origen2= Gestor_Plantas.plantasConStock(Gestor_Ordenes_Pedido.getOrden(2)).get(0);
        Planta planta_destino2=Gestor_Plantas.getPlanta(10);
        List<List> caminos_posibles2 = Gestor_Plantas.rutaPosibles(planta_origen1,planta_destino1);
        ArrayList<Ruta> rutas2 = Gestor_Plantas.plantasARutas((ArrayList)Gestor_Plantas.masCorta(caminos_posibles1,false));

        Gestor_Ordenes_Pedido.pasarAProcesada(Gestor_Ordenes_Pedido.getOrden(2),rutas2);


        Gestor_Ordenes_Pedido.pasarACancelada(Gestor_Ordenes_Pedido.getOrden(5));
        Gestor_Ordenes_Pedido.pasarACancelada(Gestor_Ordenes_Pedido.getOrden(6));

*/

        /*
        //para probar funcion rutaPosibles() y plantasConStock();
        Gestor_Plantas.registrarPlanta("planta1");
        Gestor_Plantas.registrarPlanta("planta2");
        Gestor_Plantas.registrarPlanta("planta3");
        Gestor_Plantas.registrarPlanta("planta4");
        Gestor_Plantas.registrarPlanta("planta5");
        Gestor_Plantas.registrarPlanta("planta6");
        Gestor_Plantas.registrarPlanta("planta7");
        Gestor_Plantas.registrarPlanta("planta8");
        Gestor_Plantas.registrarPlanta("planta9");
        Gestor_Plantas.registrarPlanta("planta10");

        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(1),100,60,100);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(2),151,70,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(3),102,10,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(1),Gestor_Plantas.getPlantas().get(4),103,20,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(1),Gestor_Plantas.getPlantas().get(8),104,30,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(7),105,40,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(5),108,50,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(4),102,61,160);

        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(3),Gestor_Plantas.getPlantas().get(6),109,62,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(4),Gestor_Plantas.getPlantas().get(7),110,63,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(5),Gestor_Plantas.getPlantas().get(7),180,64,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(6),Gestor_Plantas.getPlantas().get(7),170,65,140);

        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(7),Gestor_Plantas.getPlantas().get(9),140,66,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(9),111,67,140);

            //        es un digrafo de 1 a 10
            //               ----> 9 ---->
            //              /       \     \
            //             /         \     \
            //            2 --->5     \     \
            //           /     / \     \     \
            //          /     /   ----- \
            //         /     /           \     \
            //        1 --->3 --->6 ----> 8 --->10
            //         \                 /
            //          \               /
            //           \             /
            //            4 --------->7

         */

        /*
        ArrayList<Lista_insumos> insumosPlanta1 = new ArrayList();
        ArrayList<Lista_insumos> insumosOrden = new ArrayList();

        Gestor_Insumos.registrarInsumoG("es el insumo 1","kg",200,1);
        Gestor_Insumos.registrarInsumoG("es el insumo 2","m",100,0.5);

        insumosPlanta1.add(new Stock(Gestor_Insumos.getInsumo(1),Gestor_Plantas.getPlanta(1),100,10));
        insumosPlanta1.add(new Stock(Gestor_Insumos.getInsumo(2),Gestor_Plantas.getPlanta(1),100,10));
        Gestor_Plantas.getPlanta(7).setInsumos(insumosPlanta1);

        Gestor_Ordenes_Pedido.registrarOrden(Gestor_Plantas.getPlanta(10),LocalDate.now(),new ArrayList<>());
        insumosOrden.add(new Detalle_Insumos(Gestor_Ordenes_Pedido.getOrden(1),Gestor_Insumos.getInsumo(1),50));
        insumosOrden.add(new Detalle_Insumos(Gestor_Ordenes_Pedido.getOrden(1),Gestor_Insumos.getInsumo(2),50));
        Gestor_Ordenes_Pedido.getOrden(1).setInsumos_pedidos(insumosOrden);
        System.out.println(Gestor_Plantas.plantasConStock(Gestor_Ordenes_Pedido.getOrden(1)));

         */

        /*
        //Prueba del metodo  plantasBajoPuntoReposicion()
               ArrayList stock = new ArrayList();
        Gestor_Plantas.registrarPlanta("planta1");
        stock.add(new Stock(
                new Insumo_General(1,"insumo1","m",100,2),
                Gestor_Plantas.getPlantas().get(0),10,5));
        stock.add(new Stock(
                new Insumo_General(2,"insumo2","L",200,1),
                Gestor_Plantas.getPlantas().get(0),14,2));
        stock.add(new Stock(
                new Insumo_General(3,"insumo3","m",100,1),
                Gestor_Plantas.getPlantas().get(0),5,10));

        Gestor_Plantas.getPlantas().get(0).setInsumos(stock);

        Gestor_Plantas.registrarPlanta("planta2");
        ArrayList stock2 = new ArrayList();
        stock2.add(new Stock(
                new Insumo_General(1,"insumo1","m",100,2),
                Gestor_Plantas.getPlantas().get(0),10,5));
        stock2.add(new Stock(
                new Insumo_General(2,"insumo2","L",200,1),
                Gestor_Plantas.getPlantas().get(0),14,2));

        Gestor_Plantas.getPlantas().get(1).setInsumos(stock2);

        System.out.println(Gestor_Plantas.plantasBajoPuntoReposicion().toString());
        */

        /*
        //Para el testing luego, prueba de la priorityqueue PLANTA YA NO TIENE CAMIONES
        Planta planta = new Planta("Planta de facu",0001);

        planta.getCamiones().add(new Camion("1111","modelo5",2000,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("1112","modelo5",2000,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0001","modelo1",0,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0002","modelo1",0,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0111","modelo4",1000,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0112","modelo4",1000,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0011","modelo2",10,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0012","modelo2",10,10,10, LocalDate.now()));

        planta.getCamiones().add(new Camion("0021","modelo3",100,10,10, LocalDate.now()));
        planta.getCamiones().add(new Camion("0022","modelo3",100,10,10, LocalDate.now()));





        System.out.println("---------------------------------------------");
        while (!planta.getCamiones().isEmpty()){
            System.out.println(planta.getCamiones().poll().getPatente());
        }

     */
    }

    public static void getBD() throws SQLException {
        //Abro la base de datos
        Connection conexion = ConexionRemota.getConexionRemota();
        Statement stmt = conexion.createStatement();

        //Traigo los camiones
        ResultSet res = stmt.executeQuery("SELECT * FROM camion;");
        while (res.next()){
            Gestor_Camiones.traerCamionBD(res.getString("patente"), res.getString("marca"), res.getString("modelo"), Double.valueOf(res.getString("km_recorridos")), Double.valueOf(res.getString("costo_km")), Double.valueOf(res.getString("costo_hora")), LocalDate.parse(res.getString("fecha_compra")));
        }

        //Traigo los insumos
        res = stmt.executeQuery("SELECT * FROM(SELECT i.id_insumo,descripcion,unidad_medida,costo,peso,densidad FROM insumo i LEFT JOIN general ON general.id_insumo = i.id_insumo LEFT JOIN liquido ON liquido.id_insumo = i.id_insumo) A ORDER BY A.id_insumo;");
        while(res.next()){
            if(res.getString("peso") != null){
                Gestor_Insumos.traerInsumoGBD(res.getString("descripcion"),res.getString("unidad_medida"),Double.valueOf(res.getString("costo")),Double.valueOf(res.getString("peso")),Integer.valueOf(res.getString("id_insumo")));
            }else{
                Gestor_Insumos.traerInsumoLBD(res.getString("descripcion"),res.getString("unidad_medida"),Double.valueOf(res.getString("costo")),Double.valueOf(res.getString("densidad")),Integer.valueOf(res.getString("id_insumo")));
            }
        }

        //Traigo las plantas
        res = stmt.executeQuery("SELECT * FROM planta ORDER BY id_planta;");
        while(res.next()){
            Gestor_Plantas.traerPlantaBD(res.getString("nombre_planta"),Integer.valueOf(res.getString("id_planta")));
        }

        //Traigo las rutas
        res = stmt.executeQuery("SELECT * FROM ruta;");
        while(res.next()){
            Gestor_Plantas.traerRutaBD(Gestor_Plantas.getPlanta(Integer.valueOf(res.getString("id_planta_origen"))),Gestor_Plantas.getPlanta(Integer.valueOf(res.getString("id_planta_destino"))),Double.valueOf(res.getString("distancia")),Integer.valueOf(res.getString("duracion_viaje")),Double.valueOf(res.getString("cant_max_material")));
        }

        //Traigo el stock de cada planta
        res = stmt.executeQuery("SELECT * FROM stock");
        while(res.next()){
            Gestor_Plantas.traerStockBD(Integer.valueOf(res.getString("id_planta")),Gestor_Insumos.getInsumo(Integer.valueOf(res.getString("id_insumo"))),Double.valueOf(res.getString("cantidad")),Double.valueOf(res.getString("punto_reposicion")));
        }

        //Traigo las órdenes de pedido y los detalles de insumo
        res = stmt.executeQuery("SELECT * FROM detalle_insumo");
        int tam_matriz=0;
        int indice = 0;
        while(res.next()){
            tam_matriz++;
        }
        res = stmt.executeQuery("SELECT * FROM detalle_insumo ORDER BY numero_orden");
        Number[][] guardado = new Number[tam_matriz][3];
        while(res.next()){
            guardado[indice][0] = res.getInt("numero_orden");
            guardado[indice][1] = res.getInt("id_insumo");
            guardado[indice][2] = res.getDouble("cantidad");
            indice++;
        }


        res = stmt.executeQuery("SELECT * FROM orden_pedido ORDER BY numero_orden");
        while(res.next()) {
            guardarOrdenConDetalleInsumo(res,guardado,tam_matriz);
        }

        //Traigo detalles de envío
        res = stmt.executeQuery("SELECT * FROM detalle_envio ORDER BY numero_orden");
        while(res.next()){
            Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))).setDetalle_envio(new Detalle_Envio(Gestor_Camiones.getCamion(res.getString("patente")),null,Double.valueOf(res.getString("costo_envio"))));
            Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))).getDetalle_envio().setOrden(Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))));
        }

        //Traigo los caminos
        res = stmt.executeQuery("SELECT * FROM camino ORDER BY numero_orden");
        ArrayList<Ruta> rutas_asignadas;
        while(res.next()){
        if(Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))).getDetalle_envio().getRutas_asignadas() == null){
            Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))).getDetalle_envio().setRutas_asignadas(new ArrayList<Ruta>());
        }
        Gestor_Ordenes_Pedido.getOrden(Integer.valueOf(res.getString("numero_orden"))).getDetalle_envio().getRutas_asignadas().add(Gestor_Plantas.getCamino(Gestor_Plantas.getPlanta(Integer.valueOf(res.getString("id_planta_origen"))),Gestor_Plantas.getPlanta(Integer.valueOf(res.getString("id_planta_destino")))));
        }

        //Cierro la base de datos
        stmt.close();
        conexion.close();
    }

    private static void guardarOrdenConDetalleInsumo(ResultSet res, Number[][] guardado, int tam_matriz) throws SQLException {
        ArrayList<Lista_insumos> insumos = new ArrayList<>();
        int numero_orden = res.getInt("numero_orden");
        for (int i = 0; i < tam_matriz; i++){
            if (guardado[i][0].equals(numero_orden)) {
                insumos.add(new Detalle_Insumos(Gestor_Insumos.getInsumo((int) guardado[i][1]), (Double) guardado[i][2]));
            }
        }
        Gestor_Ordenes_Pedido.traerOrdenBD(numero_orden,LocalDate.parse(res.getString("fecha_solicitud")),LocalDate.parse(res.getString("fecha_maxima_entrega")),LocalDate.parse(res.getString("fecha_entrega")),Estado.valueOf(res.getString("estado")),Gestor_Plantas.getPlanta(Integer.parseInt(res.getString("id_planta"))),insumos,null);
        for(int i=0; i < insumos.size(); i++ ){
            insumos.get(i).setOrden(Gestor_Ordenes_Pedido.getOrden((int) numero_orden));
        }
    }
}
