/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_atletismo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Main_Pista_Atletismo {

    //CONSTANTES
    private static final int N_MIN_CORREDORES = 5;
    private static final int N_MAX_CORREDORES = 50;
    private static final int TIEMPO_MIN = 30;
    private static final int TIEMPO_MAX = 110;

    public static void main(String[] args) throws IOException, InterruptedException {
        //DEFINIMOS EL Nº DE CORREDORES
        int nCorredores = new Random().nextInt((N_MAX_CORREDORES - N_MIN_CORREDORES) + 1) + N_MIN_CORREDORES;
        System.out.println("Van a correr " + nCorredores + " corredores");

        //CREAMOS EL LOGGER
        Logger logger = Corredores.createLogger();

        //INSTANCIAMOS CORREDORES
        List<Corredores> lstCorredores = new ArrayList<>();
        for (int i = 0; i < nCorredores; i++) {
            lstCorredores.add(new Corredores(logger));
            lstCorredores.get(i).setName("Corredor " + (i + 1));
            lstCorredores.get(i).start();
        }
        String campeon = "";
        //DESCALIFICACIÓN DE LOS CORREDORES
        while (lstCorredores.size() > 0) {
            //TIEMPO HASTA INTERRUPIÓN
            Thread.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
            int ale = new Random().nextInt(lstCorredores.size());
            //COGEMOS A UN CORREDOR DE FORMA ALEATORIA
            Corredores corredor = lstCorredores.get(ale);
            //LO INTERRUMPIMOS
            lstCorredores.get(ale).interrupt();
            //LO ELIMINAMOS DE LA LISTA
            lstCorredores.remove(corredor);
            if (lstCorredores.size() == 1) {
                campeon = "Ya tenemos campeón: " + lstCorredores.get(0).getName() + " ha "
                        + "dado un total de " + lstCorredores.get(0).getCont() + " vueltas";
            }
        }
        Thread.sleep(1000);
        System.out.println(campeon);
        System.out.println(Thread.currentThread().getName() + " FIN");

    }
}
