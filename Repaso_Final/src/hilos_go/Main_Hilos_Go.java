/*
 Se trata de usar variables volatile como recurso compartido entre hilos.

Estos hilosGo corren en un bucle controlado por una variable string volatile ;  hacen eco del nombre del hilo y esperan aleatoriamente ( 5-10 segundos ),  mientras la variable tiene el valor “stop”.

Main creará  y arrancará 16 hilosGo. Hará una espera aleatoria prolongada  
(12-30 segundos ) y cambiará a “go” el valor de la variable volatile provocando
el fin de los hilos. Hará eco con nombre del hilo y “FIN”.

 */
package hilos_go;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Hilos_Go {

    //CONSTANTES
    private static final int N_HILOS_GO = 16;
    private static final int TIEMPO_MIN = 12000;
    private static final int TIEMPO_MAX = 30000;
    
    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Volatile rC_Volatile = new RC_Volatile();
        //INTANCIAMOS HILOS GO
        List<Hilos_Go> lstHilos_Go = new ArrayList<>();
        for (int i = 0; i < N_HILOS_GO; i++) {
            lstHilos_Go.add(new Hilos_Go(rC_Volatile));
            lstHilos_Go.get(i).setName("Hilo_GO " + (i + 1));
            lstHilos_Go.get(i).start();
        }

        //TIEMPO HASTA CAMBIAR EL VALOR DE LA VARIABLE VOLATIL
        Thread.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);

        //CAMBIAMOS EL VALOR DE LA VARIABLE VOLATIL
        rC_Volatile.setVariableVolatil("go");
        System.err.println("variable volatil apunta a " + rC_Volatile.getVariableVolatil());

        //MIENTRAS LOS HILOS GO VIVAN MAIN ESPERA
        for (int i = 0; i < N_HILOS_GO; i++) {
            lstHilos_Go.get(i).join();
        }
        for (int i = 0; i < N_HILOS_GO; i++) {
            while (lstHilos_Go.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        System.out.println(Thread.currentThread().getName()+" FIN");
    }
}
