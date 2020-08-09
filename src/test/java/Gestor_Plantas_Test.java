import Negocio.Planta;
import Servicio.Gestor_Plantas;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Gestor_Plantas_Test {

    @Test
    public void flujoMaxNumeroTest() throws SQLException {

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
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(5),105,40,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(4),104,30,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(3),Gestor_Plantas.getPlantas().get(6),108,50,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(4),Gestor_Plantas.getPlantas().get(8),102,61,160);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(5),Gestor_Plantas.getPlantas().get(7),109,62,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(6),Gestor_Plantas.getPlantas().get(7),110,63,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(7),Gestor_Plantas.getPlantas().get(9),180,64,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(7),170,65,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(9),140,66,150);
        double rta;
       rta = Gestor_Plantas.flujoMaxNumero(Gestor_Plantas.getPlanta(1),Gestor_Plantas.getPlanta(10));
       assertTrue(rta==190);

        rta= Gestor_Plantas.flujoMaxNumero(Gestor_Plantas.getPlanta(10),Gestor_Plantas.getPlanta(1));
        assertTrue(rta==0);

        rta= Gestor_Plantas.flujoMaxNumero(Gestor_Plantas.getPlanta(9),Gestor_Plantas.getPlanta(10));
        assertTrue(rta==280);

    }

    @Test
    public void flujoMaxSubPesosTest() throws SQLException{
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
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(5),105,40,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(4),104,30,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(3),Gestor_Plantas.getPlantas().get(6),108,50,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(4),Gestor_Plantas.getPlantas().get(8),102,61,160);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(5),Gestor_Plantas.getPlantas().get(7),109,62,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(6),Gestor_Plantas.getPlantas().get(7),110,63,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(7),Gestor_Plantas.getPlantas().get(9),180,64,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(7),170,65,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(9),140,66,150);
        ArrayList<Double> rta = new ArrayList<Double>();
        ArrayList<Double> esperado = new ArrayList<Double>();

        rta = Gestor_Plantas.flujoMaxSubPesos(Gestor_Plantas.getPlanta(10),Gestor_Plantas.getPlanta(1));
        System.out.println(rta);
        esperado.add(0.0);
        assertTrue(rta.equals(esperado));

        rta = Gestor_Plantas.flujoMaxSubPesos(Gestor_Plantas.getPlanta(9),Gestor_Plantas.getPlanta(10));
        System.out.println(rta);
        esperado.clear();
        esperado.add(130.0);
        esperado.add(150.0);
        assertTrue(rta.equals(esperado));

        rta = Gestor_Plantas.flujoMaxSubPesos(Gestor_Plantas.getPlanta(1),Gestor_Plantas.getPlanta(10));
        System.out.println(rta);
        esperado.clear();
        esperado.add(100.0);
        esperado.add(30.0);
        esperado.add(60.0);
        assertTrue(rta.equals(esperado));
    }

    @Test
    public void flujoMaxPlantasTest() throws SQLException {
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
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(5),105,40,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(4),104,30,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(3),Gestor_Plantas.getPlantas().get(6),108,50,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(4),Gestor_Plantas.getPlantas().get(8),102,61,160);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(5),Gestor_Plantas.getPlantas().get(7),109,62,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(6),Gestor_Plantas.getPlantas().get(7),110,63,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(7),Gestor_Plantas.getPlantas().get(9),180,64,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(7),170,65,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(9),140,66,150);
        ArrayList<ArrayList<Planta>> rta = new ArrayList<ArrayList<Planta>>();
        ArrayList<ArrayList<Planta>> esperado = new ArrayList<ArrayList<Planta>>();
        ArrayList<Planta> agregar = new ArrayList<Planta>();
        ArrayList<Planta> agregar2 = new ArrayList<Planta>();
        ArrayList<Planta> agregar3 = new ArrayList<Planta>();

        rta= Gestor_Plantas.flujoMaxPlantas(Gestor_Plantas.getPlanta(10),Gestor_Plantas.getPlanta(1));
        esperado.add(new ArrayList<>());
        System.out.println(esperado);
        System.out.println(rta);
        assertTrue(rta.equals(esperado));

        rta= Gestor_Plantas.flujoMaxPlantas(Gestor_Plantas.getPlanta(9),Gestor_Plantas.getPlanta(10));
        esperado.clear();
        agregar.add(Gestor_Plantas.getPlanta(9));
        agregar.add(Gestor_Plantas.getPlanta(8));
        agregar.add(Gestor_Plantas.getPlanta(10));
        esperado.add(agregar);
        agregar2.add(Gestor_Plantas.getPlanta(9));
        agregar2.add(Gestor_Plantas.getPlanta(10));
        esperado.add(agregar2);
        System.out.println(esperado);
        System.out.println(rta);
        assertTrue(rta.equals(esperado));

        rta= Gestor_Plantas.flujoMaxPlantas(Gestor_Plantas.getPlanta(1),Gestor_Plantas.getPlanta(10));
        esperado.clear();
        agregar.clear();
        agregar2.clear();
        agregar.add(Gestor_Plantas.getPlanta(1));
        agregar.add(Gestor_Plantas.getPlanta(2));
        agregar.add(Gestor_Plantas.getPlanta(5));
        agregar.add(Gestor_Plantas.getPlanta(9));
        agregar.add(Gestor_Plantas.getPlanta(8));
        agregar.add(Gestor_Plantas.getPlanta(10));
        agregar2.add(Gestor_Plantas.getPlanta(1));
        agregar2.add(Gestor_Plantas.getPlanta(3));
        agregar2.add(Gestor_Plantas.getPlanta(6));
        agregar2.add(Gestor_Plantas.getPlanta(8));
        agregar2.add(Gestor_Plantas.getPlanta(10));
        agregar3.add(Gestor_Plantas.getPlanta(1));
        agregar3.add(Gestor_Plantas.getPlanta(3));
        agregar3.add(Gestor_Plantas.getPlanta(5));
        agregar3.add(Gestor_Plantas.getPlanta(9));
        agregar3.add(Gestor_Plantas.getPlanta(10));
        esperado.add(agregar);
        esperado.add(agregar2);
        esperado.add(agregar3);
        System.out.println(esperado);
        System.out.println(rta);
        assertTrue(rta.equals(esperado));

    }

    @Test
    public void matrizDeGafoPorPesoTest() throws SQLException {

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
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(5),105,40,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(4),104,30,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(3),Gestor_Plantas.getPlantas().get(6),108,50,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(4),Gestor_Plantas.getPlantas().get(8),102,61,160);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(5),Gestor_Plantas.getPlantas().get(7),109,62,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(6),Gestor_Plantas.getPlantas().get(7),110,63,120);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(7),Gestor_Plantas.getPlantas().get(9),180,64,130);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(7),170,65,140);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(8),Gestor_Plantas.getPlantas().get(9),140,66,150);

        Double[][] matriz = Gestor_Plantas.matrizDeGafoPorPeso();
        for(int i=0; i < Gestor_Plantas.getPlantas().size();i++){
            for(int j=0; j < Gestor_Plantas.getPlantas().size();j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

    @Test
    public void plantasPageRankTest() throws SQLException {

        // A conecta a B y a C
        // B conecta a C
        // C conecta a A

        Gestor_Plantas.registrarPlanta("plantaA");
        Gestor_Plantas.registrarPlanta("plantaB");
        Gestor_Plantas.registrarPlanta("plantaC");

        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(1),100,60,100);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(2),151,70,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(1),Gestor_Plantas.getPlantas().get(2),102,10,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(0),103,20,120);

        System.out.println(Gestor_Plantas.getPlantas());
        ArrayList<Planta> rta = Gestor_Plantas.plantasPageRank();
        System.out.println(rta);

    }

    @Test
    public void PageRankTest() throws SQLException {

        // A conecta a B y a C
        // B conecta a C
        // C conecta a A

        Gestor_Plantas.registrarPlanta("plantaA");
        Gestor_Plantas.registrarPlanta("plantaB");
        Gestor_Plantas.registrarPlanta("plantaC");

        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(1),100,60,100);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(0),Gestor_Plantas.getPlantas().get(2),151,70,150);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(1),Gestor_Plantas.getPlantas().get(2),102,10,110);
        Gestor_Plantas.conectar(Gestor_Plantas.getPlantas().get(2),Gestor_Plantas.getPlantas().get(0),103,20,120);

        ArrayList<Double> puntajes = new ArrayList<>();
        puntajes.add(1.0);
        puntajes.add(1.0);
        puntajes.add(1.0);

        System.out.println(Gestor_Plantas.PageRank(puntajes));

    }
}
