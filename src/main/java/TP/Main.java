package TP;

import Daos.ConexionRemota;
import Daos.PlantaDao;
import Daos.PlantaDaoDB;
import Interface.Pantalla_Principal;
import Servicio.Gestor_Camiones;
import Servicio.Gestor_Pantalla;
import Servicio.Gestor_Plantas;


import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        PlantaDaoDB plantaDao = new PlantaDaoDB();

        Gestor_Plantas.setPlantas(plantaDao.getPlanta());
        //Gestor_Plantas.setRutas();

        Gestor_Pantalla.visualizarPantalla_principal();
        //System.out.println(Gestor_Plantas.flujoMaxNumero(Gestor_Plantas.getPlanta(1),Gestor_Plantas.getPlanta(10)));
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
            //                    9----->
            //                   / \     \
            //                  /   \     \
            //           2 --->5     \     \
            //          /     /       \     \
            //         /     /         \     \
            //        1 --->3 --->6 --->8 --->10
            //         \               /
            //          \             /
            //           \           /
            //            4 ------->7

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
    /*
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
        res = stmt.executeQuery("SELECT * FROM insumo;");
        while (res.next()){
            ResultSet rest = stmt.executeQuery("SELECT * FROM ")
        }


        //Cierro la base de datos
        stmt.close();
        conexion.close();
    }

     */
}
